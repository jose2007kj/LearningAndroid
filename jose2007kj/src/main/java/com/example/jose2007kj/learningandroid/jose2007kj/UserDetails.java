package com.example.jose2007kj.learningandroid.jose2007kj;

import com.example.jose2007kj.learningandroid.jose2007kj.model.UserData;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

public class UserDetails extends AppCompatActivity {
    String u_pno, u_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        TextView f_name = (TextView) findViewById(R.id.value_firstname);
        TextView l_name = (TextView) findViewById(R.id.value_lastname);
        TextView user_name = (TextView) findViewById(R.id.value_username);
        TextView email = (TextView) findViewById(R.id.value_email);
        TextView pno = (TextView) findViewById(R.id.value_phone);
        UserData user = new UserData();
        Intent intent = getIntent();
//        Map<String, String>> hashMap = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("selectedBanksAndAllCards");
        try {
            Map<String, String> data = (Map<String, String>) intent.getSerializableExtra("map");
            Log.d("values inside map is", "Map**" + data);
            Log.d("values inside map is", "Map type**" + data.getClass().getName());
            //https://stackoverflow.com/questions/26366152/how-to-dynamically-set-text-to-textview
            f_name.setText(data.get("f_name"));
            l_name.setText(data.get("l_name"));
            user_name.setText(data.get("username"));
            email.setText(data.get("email"));
            pno.setText(data.get("pno"));
            u_pno = "tel:" + data.get("pno");
//        u_email=data.get("email");
            u_email = "mailto:" + data.get("email");

            pno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(u_pno)));

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse(u_email));
                    startActivity(emailIntent);

                }
            });
        } catch (Exception ex) {
            Log.d("exception", "ex" + ex);
        }

    }
}
