package com.example.jose2007kj.learningandroid.jose2007kj;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.jose2007kj.learningandroid.jose2007kj.model.UserData;

public class SignUp extends Fragment {
    private EditText f_name, l_name, email, pwd, p_no, re_pwd, dob, u_name;
    private boolean signin_status;
    //    private DatePicker dob;
    Calendar cal = Calendar.getInstance();
    private String s_fname, s_lname, s_email, s_pwd, s_dob, s_pno, s_repwd, s_uname;
    //https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
    public static final Pattern VALID_PASSWOLD_REGEX_ALPHA_NUM
            = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    //https://stackoverflow.com/questions/8204680/java-regex-email
    public static final Pattern VALID_EMAIL_REGEX_ALPHA_NUM
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_REGEX_NUM
            = Pattern.compile("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$");//https://stackoverflow.com/questions/18351553/regular-expression-validation-for-indian-phone-number-and-mobile-number#18351672

    public static final Pattern VALID_DOB_NUM
            = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");//YYYY-MM-DD https://stackoverflow.com/questions/2149680/regex-date-format-validation-on-java

    //    private Button gtoLogin,signin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        Button signin = view.findViewById(R.id.button3);
        Button login = view.findViewById(R.id.button4);
        Button shortcut = view.findViewById(R.id.shortcut);
        f_name = view.findViewById(R.id.editText5);
        l_name = view.findViewById(R.id.editText9);
        email = view.findViewById(R.id.editText);
        pwd = view.findViewById(R.id.editText3);
        p_no = view.findViewById(R.id.editText10);
        re_pwd = view.findViewById(R.id.editText11);
        dob = view.findViewById(R.id.dateDesc);
        u_name = view.findViewById(R.id.u_name);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                cal.set(Calendar.YEAR, i);
                cal.set(Calendar.MONTH, i1);
                cal.set(Calendar.DATE, i2);
                updatelabel();
            }
        };
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), date, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Login(), null).addToBackStack(null).commit();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        shortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // for temporary use only
                Intent intent = new Intent(getContext(), Dashboard.class);
                startActivity(intent);
            }
        });


        return (view);
    }

    public void updatelabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(cal.getTime()));

    }

    public void register() {
        initalize();
    }

    public void initalize() {
        s_fname = f_name.getText().toString().trim();
        s_lname = l_name.getText().toString().trim();
        s_email = email.getText().toString().trim();
        s_pwd = pwd.getText().toString().trim();
        s_repwd = re_pwd.getText().toString().trim();
        s_dob = dob.getText().toString().trim();
        s_pno = p_no.getText().toString().trim();
        s_uname = u_name.getText().toString().trim();

        if (!validate()) {
            Toast.makeText(getActivity(), "Signup failed.Please Enter valid details", Toast.LENGTH_SHORT).show();

        } else {
            UserData user = new UserData();
            signin_status = user.register(s_fname, s_lname, s_email, s_pwd, s_pno, s_dob, s_uname);
            if (signin_status) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Login(), null).addToBackStack(null).commit();
            }
            //Toast.makeText(getActivity(), "Its seems correct", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate() {
        boolean value = true;
        if (s_fname.isEmpty() || s_fname.length() > 32) {
            f_name.setError("Please Enter valid First Name");
            value = false;
        }
        if (s_uname.isEmpty() || s_uname.length() < 4 || s_uname.length() > 32) {
            u_name.setError("Please Enter valid User Name");
            value = false;
        }
        if (s_lname.isEmpty() || s_lname.length() > 32) {
            l_name.setError("Please Enter valid last Name");
            value = false;
        }
        if (validatePassword(s_pwd)) {

            if (!new String(s_pwd).equals(s_repwd)) {
                re_pwd.setError("Please type same password");
                value = false;
            }
//

        }
        if (!validatePassword(s_pwd)) {
            pwd.setError("Please Enter a Password having a Capital letter,number,special chrecter and minimum length of 8");
            value = false;
        }
        if (!validateEmail(s_email)) {
            email.setError("Please enter valid Emailid!");
            value = false;

        }
        if (s_dob.isEmpty()) {
            Toast.makeText(getActivity(), "Please Slelct datee", Toast.LENGTH_SHORT).show();

            value = false;

        }
        if (!validatePhone(s_pno)) {
            p_no.setError("Please enter valid Phone Number!");
            value = false;

        }
        return value;
    }

    public static boolean validatePassword(String pwStr) {
        Log.d("testing password", "password" + pwStr);
        Matcher matcher = VALID_PASSWOLD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }

    public static boolean validateEmail(String pwStr) {
        Log.d("testing Email", "Email" + pwStr);
        Matcher matcher = VALID_EMAIL_REGEX_ALPHA_NUM.matcher(pwStr);
        Log.d("email comparison", "matcher result" + matcher.matches());
        return matcher.matches();
    }

    public static boolean validatePhone(String pwStr) {
        Log.d("testing phone", "phone number" + pwStr);
        Matcher matcher = VALID_PHONE_REGEX_NUM.matcher(pwStr);
        return matcher.matches();
    }

    public static boolean validateDob(String pwStr) {
        Log.d("testing dob", "dob*****" + pwStr);
        Matcher matcher = VALID_DOB_NUM.matcher(pwStr);
        return matcher.matches();
    }
}
