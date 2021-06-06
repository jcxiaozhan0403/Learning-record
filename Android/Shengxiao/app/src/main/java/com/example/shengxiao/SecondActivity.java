package com.example.shengxiao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private int index;
    private ImageView imageView;
    private TextView textView;
    private String[] data = {"鼠","牛","虎"};
    private int[] imgdata = {R.drawable.shu,
            R.drawable.niu,R.drawable.hu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = (ImageView)findViewById(R.id.img);
        textView = (TextView)findViewById(R.id.text);
        Intent intent = getIntent();
        index = intent.getIntExtra("ShengXiao",0);
        imageView.setImageResource(imgdata[index]);
        textView.setText(data[index]);

    }
}
