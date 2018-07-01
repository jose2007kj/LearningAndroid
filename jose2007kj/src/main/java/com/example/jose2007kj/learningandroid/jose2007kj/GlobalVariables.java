package com.example.jose2007kj.learningandroid.jose2007kj;

import android.app.Application;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalVariables extends Application {
    private JSONObject marcelo = new JSONObject();
    private JSONObject ronoldo = new JSONObject();
    private JSONObject zidane = new JSONObject();
    private JSONObject vijanyan = new JSONObject();
    private JSONObject bhutia = new JSONObject();
    private JSONObject chetari = new JSONObject();
    private JSONArray recycler_array = new JSONArray();

    public void players_info() {
        try {

            marcelo.put("id", "https://en.wikipedia.org/wiki/Marcelo_(footballer,_born_1988)");
            marcelo.put("image", R.drawable.mercilo);
            marcelo.put("desc", "Mercilo plays for Brazil");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();
        }
        recycler_array.put(marcelo);
        try {

            ronoldo.put("id", "https://it.wikipedia.org/wiki/Cristiano_Ronaldo");
            ronoldo.put("image", R.drawable.ronaldho);
            ronoldo.put("desc", "Ronaldho plays for portughese");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();
        }
        recycler_array.put(ronoldo);
        try {

            zidane.put("id", "https://en.wikipedia.org/wiki/Zinedine_Zidane");
            zidane.put("image", R.drawable.zidane);
            zidane.put("desc", "Zidane plays for France");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();

        }
        recycler_array.put(zidane);
        try {

            vijanyan.put("id", "https://en.wikipedia.org/wiki/I._M._Vijayan");
            vijanyan.put("image", R.drawable.vijayan);
            vijanyan.put("desc", "vijayan played for India");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();
        }
        recycler_array.put(vijanyan);
        try {

            chetari.put("id", "https://en.wikipedia.org/wiki/Sunil_Chhetri");
            chetari.put("image", R.drawable.sunil);
            chetari.put("desc", "Chettari plays for India");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();
        }
        recycler_array.put(chetari);
        try {

            bhutia.put("id", "https://en.wikipedia.org/wiki/Bhaichung_Bhutia");
            bhutia.put("image", R.drawable.baichung);
            bhutia.put("desc", "bhutia played for India");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("", "e" + e);
            e.printStackTrace();
        }
        recycler_array.put(bhutia);
    }

    public JSONArray get_players_info() {

        return recycler_array;
    }
}
