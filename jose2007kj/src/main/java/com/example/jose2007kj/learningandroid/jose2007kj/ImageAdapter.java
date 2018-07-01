package com.example.jose2007kj.learningandroid.jose2007kj;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class ImageAdapter extends BaseAdapter {

    private static JSONArray json_data;
    private Context context;

    public ImageAdapter(Context c, JSONArray players) {
        context = c;
        json_data = players;
    }

    @Override
    public int getCount() {
        return json_data.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ImageView imgView, delete;
//        final ViewHolder holder=new ViewHolder(view);


        View child;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        child = inflater.inflate(R.layout.grid_view, null);
        /**mImageView = child.findViewById(R.id.icon);
         delete=child.findViewById(R.id.imageView);**/
        delete = child.findViewById(R.id.imageView);
        imgView = child.findViewById(R.id.icon);
        delete.setTag(Integer.valueOf(i));
        imgView.setTag(Integer.valueOf(i));
        try {
            JSONObject temp = json_data.getJSONObject(i);
            imgView.setImageResource(temp.getInt("image"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(19)
            public void onClick(final View view) {
                //Creating the instance of PopupMenu

                PopupMenu popup = new PopupMenu(view.getContext(), delete);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Integer position = (Integer) view.getTag();

                        json_data.remove(position);
                        ImageAdapter.this.notifyDataSetChanged();
                        return true;
                    }
                });

                popup.show(); //showing popup menu


            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    int b_id= delete.getId();
                    Integer position = (Integer) view.getTag();

                    JSONObject temp = json_data.getJSONObject(position);
                    String desc = temp.getString("id");
                    Uri uri = Uri.parse(desc);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    view.getContext().startActivity(intent);
                } catch (JSONException ex) {
                    Log.d("", "Exception" + ex);
                }
            }
        });


        return child;
    }

    /**private static class ViewHolder{
     public ImageView delete,imgView;
     public ViewHolder(View v){
     v.setOnClickListener(this);
     delete=v.findViewById(R.id.imageView);
     imgView=v.findViewById(R.id.icon);
     }
     @Override public void onClick(View view) {

     try {
     int b_id= delete.getId();
     Integer position = (Integer)view.getTag();

     JSONObject temp = json_data.getJSONObject(position);
     String desc = temp.getString("id");
     Uri uri = Uri.parse(desc);
     Intent intent = new Intent(Intent.ACTION_VIEW, uri);
     view.getContext().startActivity(intent);
     } catch (JSONException ex) {
     Log.d("", "Exception" + ex);
     }
     Log.d(TAG, "onClick");

     }
     }**/
}
