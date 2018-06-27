package com.example.jose2007kj.learningandroid.jose2007kj.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static String f_name;
    private static String l_name;
    private static String email;
    private static String pwd;
    private static String pno;
    private static String dob;
    private static String u_name;
    private static boolean reg_status;
    private static boolean login_status;

    public UserData() {
        reg_status = true;
        login_status = false;
    }

    public boolean register(String f_name, String l_name, String email, String pwd, String pno, String dob, String u_name) {
        try {
            this.email = email;
            this.l_name = l_name;
            this.f_name = f_name;
            this.pwd = pwd;
            this.pno = pno;
            this.dob = dob;
            this.u_name = u_name;
        } catch (Exception ex) {
            Log.d("", "Registration error" + ex);
            reg_status = false;

        }
        return reg_status;
    }

    public boolean login(String email, String pwd) {
        Log.d("inside login", "login function" + email + pwd);
        try {
            if (email.equals(this.email) && pwd.equals(this.pwd)) {
                login_status = true;
                Log.d("inside sucess", "inside matching credentials" + login_status);

            }
        } catch (Exception ex) {
            Log.d("", "Login error" + ex);

        }
        return login_status;
    }

    public Map<String, String> userDetails() {
        Log.d("map user details", "inside mapkj");
        Map<String, String> user_data = new HashMap<String, String>();
        user_data.put("f_name", f_name);
        user_data.put("l_name", l_name);
        user_data.put("email", email);
        user_data.put("pwd", pwd);
        user_data.put("pno", pno);
        user_data.put("username", u_name);
        Log.d("map user details", "inside mapkj" + user_data);
        return user_data;
    }

}
