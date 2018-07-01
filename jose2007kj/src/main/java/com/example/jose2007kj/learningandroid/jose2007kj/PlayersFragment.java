package com.example.jose2007kj.learningandroid.jose2007kj;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayersFragment extends Fragment {
    GridView gridView;

    public PlayersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GlobalVariables players=(GlobalVariables)getActivity().getApplicationContext();
        final JSONArray players_info;
        View view = inflater.inflate(R.layout.players_fragment, container, false);
        gridView = view.findViewById(R.id.gridview);
        players_info=players.get_players_info();
        gridView.setAdapter(new ImageAdapter(getActivity(),players_info));
        /**gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    JSONObject temp = players_info.getJSONObject(i);
                    String desc = temp.getString("id");
                    Uri uri = Uri.parse(desc);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    view.getContext().startActivity(intent);
                } catch (JSONException ex) {
                    Log.d("", "Exception" + ex);
                }

            }
        });**/
        return view;
    }
}
