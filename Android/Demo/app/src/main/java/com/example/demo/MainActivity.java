package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void Click(View view){
        et = (EditText) findViewById(R.id.username);
        switch (view.getId()){
            case R.id.btn://此处是对布局中设置的id直接进行判断，
                // 不需要对控件进行获取（findviewByID）
                Toast.makeText(this, et.getText().toString() + "  你好！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}