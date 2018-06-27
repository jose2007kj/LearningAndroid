package com.example.jose2007kj.learningandroid.jose2007kj;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NamesFragment extends Fragment {

// test.put("id:",1);

    private Map<Integer, String> r_data = new HashMap<Integer, String>() {{
        put(R.drawable.mercilo, "Mercilo plays for Brazil");
        put(R.drawable.messi, "Messi plays for Argentina");
        put(R.drawable.ronaldho, "Ronaldo plays for Portugal");
        put(R.drawable.neymar, "Neymar plays for brazil");
        put(R.drawable.baichung, "Bhutia played for India");
        put(R.drawable.vijayan, "IM Vijayan played for India");
        put(R.drawable.sunil, "Chetari played for India");
        put(R.drawable.zidane, "Zidane played for France");
        put(R.drawable.zidane, "Zidane played for France");
    }};
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NamesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.names_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        JSONObject marcelo=new JSONObject();
        JSONObject ronoldo=new JSONObject();
        JSONObject zidane =new JSONObject();
        JSONArray recycler_array=new JSONArray();
        try {

            marcelo.put("id", "1");
            marcelo.put("image", R.drawable.mercilo);
            marcelo.put("desc", "Mercilo plays for Brazil");

        }catch(JSONException e) {
            // TODO Auto-generated catch block
            Log.d("","e"+e);
            e.printStackTrace();
        }
        recycler_array.put(marcelo);
        try {

            ronoldo.put("id", "2");
            ronoldo.put("image", R.drawable.ronaldho);
            ronoldo.put("desc", "Ronaldho plays for portughese");

        }catch(JSONException e) {
            // TODO Auto-generated catch block
            Log.d("","e"+e);
            e.printStackTrace();
        }
        recycler_array.put(ronoldo);
        try {

            zidane.put("id", "3");
            zidane.put("image", R.drawable.zidane);
            zidane.put("desc", "Zidane plays for France");

        }catch(JSONException e) {
            // TODO Auto-generated catch block
            Log.d("","e"+e);
            e.printStackTrace();
        }
        recycler_array.put(zidane);
        Integer[] imageIDs = {
                R.drawable.mercilo, R.drawable.messi, R.drawable.ronaldho,
                R.drawable.neymar, R.drawable.baichung, R.drawable.vijayan, R.drawable.sunil, R.drawable.zidane, R.drawable.zidane
        };
//        String[] myDataset = new String[] {"string1","string2","string3","string4","string5"};
        mAdapter = new GridAdapter(recycler_array);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }
}
