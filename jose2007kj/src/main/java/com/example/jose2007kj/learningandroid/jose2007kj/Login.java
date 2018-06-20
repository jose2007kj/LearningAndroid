package com.example.jose2007kj.learningandroid.jose2007kj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login extends Fragment {
    private EditText email,pwd;
    private String s_email,s_pwd;
    //https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
    public static final Pattern VALID_PASSWOLD_REGEX_ALPHA_NUM
            = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    //https://stackoverflow.com/questions/8204680/java-regex-email
    public static final Pattern VALID_EMAIL_REGEX_ALPHA_NUM
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        FragmentManager fragmentManager;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button gotTosignup = view.findViewById(R.id.button2);
        Button Login=view.findViewById(R.id.button);
        gotTosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.popBackStack();
            }
        });
        email=view.findViewById(R.id.editText6);
        pwd=view.findViewById(R.id.editText8);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        return(view);
    }
    public void login(){
        initialize();
    }
    public void initialize(){
        s_email=email.getText().toString().trim();
        s_pwd=pwd.getText().toString().trim();
        if(!validate()){
            Toast.makeText(getActivity(), "Signup failed.Please Enter valid details", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getActivity(), "Its seems correct", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate() {
        boolean value = true;


        if (!validatePassword(s_pwd)) {
            pwd.setError("Please Enter a valid Password");
            value = false;
        }
        if (!validateEmail(s_email)) {
            email.setError("Please enter valid Emailid!");
            value = false;

        }

        return value;
    }
    public static boolean validatePassword(String pwStr) {
        Log.d("testing password","password"+pwStr);
        Matcher matcher = VALID_PASSWOLD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }
    public static boolean validateEmail(String pwStr) {
        Log.d("testing Email","Email"+pwStr);
        Matcher matcher = VALID_EMAIL_REGEX_ALPHA_NUM.matcher(pwStr);
        Log.d("email comparison","matcher result"+matcher.matches());
        return matcher.matches();
    }
}
