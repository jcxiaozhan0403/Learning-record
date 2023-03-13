package com.example.demo08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ImageAdpter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view);
        adpter = new ImageAdpter(this);
        gridView.setAdapter(adpter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long imgRID = adpter.getItemId(position);
                Log.d("Main", "图片资源: "+imgRID);
            }
        });
    }
}