package com.example.jose2007kj.learningandroid.jose2007kj;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Integer[] imageIDs = {
            R.drawable.mercilo, R.drawable.messi, R.drawable.ronaldho,
            R.drawable.neymar
    };
    private Context context;
    public ImageAdapter(Context c) {
        context =c;
    }

    @Override
    public int getCount() {
        return imageIDs.length;
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
        ImageView mImageView;
        if (view == null) {
            mImageView = new ImageView(context);
            mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(16, 16, 16, 16);
        } else {
            mImageView = (ImageView) view;
        }
        mImageView.setImageResource(imageIDs[i]);
        return mImageView;
    }


}
