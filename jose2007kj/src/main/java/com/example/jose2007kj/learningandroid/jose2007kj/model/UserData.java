package com.example.jose2007kj.learningandroid.jose2007kj.model;

import android.util.Log;

public class UserData {
    private static String f_name;
    private static String l_name;
    private static String email;
    private static String pwd;
    private static String pno;
    private static String dob;
    private static boolean reg_status;
    private static boolean login_status;
    public UserData(){
        reg_status=true;
        login_status=false;
    }
    public boolean register(String f_name, String l_name, String email, String pwd, String pno, String dob){
        try {
            this.email = email;
            this.l_name = l_name;
            this.f_name = f_name;
            this.pwd = pwd;
            this.pno = pno;
            this.dob = dob;
        }catch (Exception ex){
            Log.d("","Registration error"+ex);
            reg_status=false;

        }
        return reg_status;
    }
    public boolean login(String email,String pwd){
        Log.d("inside login","login function"+email+pwd);
        try{
            if(email.equals(this.email) && pwd.equals(this.pwd)){
                login_status=true;
                Log.d("inside sucess","inside matching credentials"+login_status);

            }
        }catch (Exception ex){
            Log.d("","Login error"+ex);

        }
        return login_status;
    }

}
