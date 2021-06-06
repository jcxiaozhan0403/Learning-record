package com.example.shengxiao;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private Button enterBtn;
    private String[] data = {"鼠","牛","虎"};
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner)findViewById(R.id.sp);
        enterBtn = (Button)findViewById(R.id.enter);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = sp.getSelectedItemPosition();
                Log.d("ShengXiao","你选择的生肖"+index+data[index]);
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                intent.putExtra("ShengXiao",index);
                startActivity(intent);
            }
        });
    }
}