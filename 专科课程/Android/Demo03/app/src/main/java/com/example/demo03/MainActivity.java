package com.example.demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button saveBtn,readBtn,saveSpBtn,readSpBtn;
    TextView showHint;
    EditText editText,nameEdit,telEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn = findViewById(R.id.save);
        readBtn = findViewById(R.id.read);
        saveSpBtn = findViewById(R.id.saveSP);
        readSpBtn = findViewById(R.id.readSP);
        showHint = findViewById(R.id.hint);
        editText = findViewById(R.id.input);
        nameEdit = findViewById(R.id.edit1);
        telEdit = findViewById(R.id.edit2);

        saveBtn.setOnClickListener(this);
        saveSpBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
        readSpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences sp = getSharedPreferences("phoneBook",Context.MODE_PRIVATE);
        switch (view.getId()) {
            case R.id.saveSP:
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",nameEdit.getText().toString().trim());
                editor.putString("tel",telEdit.getText().toString().trim());
                editor.commit();//提交数据
                nameEdit.setText("");
                telEdit.setText("");
                break;
            case R.id.readSP:
                nameEdit.setText(sp.getString("name",null));
                telEdit.setText(sp.getString("tel",null));
                break;
            case R.id.save:
                String inputStr = editText.getText().toString();
                FileOutputStream f_out;
                try {
                    f_out = openFileOutput("test.txt", Context.MODE_APPEND);
                    f_out.write(inputStr.getBytes());
                    showHint.setText("保存成功！");
                    editText.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.read:
                String readStr;
                FileInputStream f_in;
                byte[] buffer = new byte[1024];
                try {
                    f_in = openFileInput("test.txt");
                    int bytes = f_in.read(buffer);
                    readStr = new String(buffer,0,bytes);
                    showHint.setText("读取成功！");
                    editText.setText(readStr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}