package com.example.demo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView loginid,pwd;
    private EditText editLoginid,editPwd;
    private CheckBox checkBox;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("phoneBook", Context.MODE_PRIVATE);

        loginid = findViewById(R.id.loginid);
        pwd = findViewById(R.id.pwd);

        editLoginid = findViewById(R.id.edit_loginid);
        editPwd = findViewById(R.id.edit_pwd);

        checkBox = findViewById(R.id.chkbox);
        button = findViewById(R.id.login);

        button.setOnClickListener(this);

        editLoginid.setText(sp.getString("loginId",null));
        editPwd.setText(sp.getString("pwd",null));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("loginId",editLoginid.getText().toString().trim());
                    editor.putString("pwd",editPwd.getText().toString().trim());
                    editor.commit();//提交数据
                }else {

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                if (editPwd.getText().toString().equals("123456")) {
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }
            break;
        }
    }
}