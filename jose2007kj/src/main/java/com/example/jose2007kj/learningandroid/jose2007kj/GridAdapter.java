package com.example.jose2007kj.learningandroid.jose2007kj;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private static JSONArray json_data;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageView imgView, delete;
        public TextView mTextView;


        public ViewHolder(View v) {

            super(v);
            v.setOnClickListener(this);
            imgView = v.findViewById(R.id.icon);

            mTextView = v.findViewById(R.id.secondLine);
            delete = v.findViewById(R.id.imageView);

        }

        @Override
        public void onClick(View view) {
            Log.d("kkk", "testjose" + String.valueOf(getAdapterPosition()));
            try {
                JSONObject temp = json_data.getJSONObject(getAdapterPosition());
                String desc = temp.getString("id");
                Uri uri = Uri.parse(desc);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            } catch (JSONException ex) {
                Log.d("", "Exception" + ex);
            }
            Log.d(TAG, "onClick");
//            view.findFocus()

//            test();

        }
    }

    public GridAdapter(JSONArray data) {
        json_data = data;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false);
//        v.setOnClickListener();
        Log.d("error layout", "layout_inf" + LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false).toString());

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            JSONObject temp = json_data.getJSONObject(position);
            String desc = temp.getString("desc");
            Integer img = temp.getInt("image");
            holder.imgView.setImageResource(img);
            holder.mTextView.setText(desc);
        } catch (JSONException ex) {
            Log.d("", "Exception" + ex);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu

                PopupMenu popup = new PopupMenu(view.getContext(), holder.delete);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        remove(position);
                        return true;
                    }
                });

                popup.show(); //showing popup menu


            }
        });


    }

    @TargetApi(19)
    public void remove(int position) {
        Log.d("remove", "remove working" + position + json_data);
        json_data.remove(position);
        GridAdapter.this.notifyDataSetChanged();


        //        notifyItemRemoved(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return json_data.length();
    }


}

