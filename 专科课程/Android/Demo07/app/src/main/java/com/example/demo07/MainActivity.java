package com.example.demo07;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.demo7.R;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private Integer[] mThumbIds = {
            R.drawable.sample_thumb_0,
            R.drawable.sample_thumb_1,
            R.drawable.sample_thumb_2,
            R.drawable.sample_thumb_3,
            R.drawable.sample_thumb_4,
            R.drawable.sample_thumb_5,
            R.drawable.sample_thumb_6,
            R.drawable.sample_thumb_7,
    };

    private Integer[] mImageIds = {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7,
    };

    private ImageSwitcher mswitcher;
    private HorizontalScrollView hsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mswitcher = findViewById(R.id.switcher);
        hsv = findViewById(R.id.gallery);
        mswitcher.setFactory(this);
        initView();
    }

    private void initView() {
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.BLACK);
        for (int i=0; i<mThumbIds.length ;i++) {
            ImageView img = new ImageView(this);
            img.setId(i);
            img.setImageResource(mThumbIds[i]);
            layout.addView(img);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mswitcher.setImageResource(mImageIds[v.getId()]);
                }
            });
        }

        hsv.addView(layout);
    }

    @Override
    public View makeView() {
        ImageView img = new ImageView(this);
        img.setBackgroundColor(Color.BLACK); //背景色
        img.setScaleType(ImageView.ScaleType.FIT_CENTER); //图片格式化
        img.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        return img;
    }
}