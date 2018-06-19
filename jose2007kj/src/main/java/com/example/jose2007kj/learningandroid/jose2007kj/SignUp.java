package com.example.jose2007kj.learningandroid.jose2007kj;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SignUp extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        Button signin = view.findViewById(R.id.button3);
        Button login = view.findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Login(),null).addToBackStack(null).commit();
            }
        });

        return(view);
    }
}
