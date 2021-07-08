package com.example.demo08;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdpter extends BaseAdapter {
    private Context context;
    private  int[] mImages = {R.drawable.imag_1,
                R.drawable.imag_2,
                R.drawable.imag_3,
                R.drawable.imag_4,
                R.drawable.imag_5,
                R.drawable.imag_6,
                R.drawable.imag_7,
                R.drawable.imag_8,
                };

    public ImageAdpter(MainActivity mainActivity) {
    }

    public void ImageAdpter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mImages[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(350,350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImages[position]);

        return imageView;
    }
}
