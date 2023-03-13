package com.example.demo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button createBtn,addBtn,dropBtn;
    MySQLiteDB db = new MySQLiteDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBtn = findViewById(R.id.create);
        addBtn = findViewById(R.id.add);
        dropBtn = findViewById(R.id.drop);

        createBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        dropBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create:
                db.create(MainActivity.this);
            break;
            case R.id.drop:
                db.deleteDB();
            break;
        }
    }
}