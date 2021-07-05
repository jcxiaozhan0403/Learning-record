package com.example.demo04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView loginid,pwd;
    private EditText editLoginid,editPwd;
    private CheckBox checkBox;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginid = findViewById(R.id.loginid);
        pwd = findViewById(R.id.pwd);

        editLoginid = findViewById(R.id.edit_loginid);
        editPwd = findViewById(R.id.edit_pwd);

        checkBox = findViewById(R.id.chkbox);
        button = findViewById(R.id.login);
    }
}