package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page2Activity.class);
                startActivity(intent);
            }
        });

        text = findViewById(R.id.text);
        text.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        text.getPaint().setAntiAlias(true); //去锯齿
        text.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线

    }
}