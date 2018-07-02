//package com.example.jose2007kj.learningandroid.jose2007kj;
//
//import android.os.Bundle;
//import android.preference.PreferenceFragment;
//import android.support.v7.app.AppCompatActivity;
//
//public class SettingsFragment extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settings);
//        getFragmentManager().beginTransaction().add(android.R.id.content,new Settings(),null).commit();
//
//
//    }
//public static class Settings extends PreferenceFragment {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.settings);
//    }
//
//
//}
//}

package com.example.jose2007kj.learningandroid.jose2007kj;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.settings);
        getFragmentManager().beginTransaction().add(android.R.id.content,new MainSettingsFragment()).commit();


    }
    public static class MainSettingsFragment extends PreferenceFragment{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);

        }
    }
}