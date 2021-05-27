package com.example.demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class TextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private Button btnd,submitBtn;
    private EditText userName;
    private RadioButton rd2;
    private Spinner sp;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_text);
        title = (TextView)findViewById(R.id.title);
        title.setTextColor(R.color.teal_200);
        title.setTextColor(Color.MAGENTA);
        title.setTextColor(Color.parseColor("#FF6200EE"));*/
        setContentView(R.layout.activity_main);
        btnd = (Button) findViewById(R.id.btn);
        submitBtn = (Button) findViewById(R.id.submitbtn);
        rd2 = (RadioButton) findViewById(R.id.rd2);
        sp = (Spinner) findViewById(R.id.sp);
        btnd.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        userName = (EditText)findViewById(R.id.username);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] data = getResources().getStringArray(R.array.shengxiao);
                Toast.makeText(TextActivity.this,data[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        btnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //userName.getText()获取文本框内容
//                Toast.makeText(getApplicationContext(), userName.getText().toString()+",你好！",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                String str = userName.getText().toString();
                if(!TextUtils.isEmpty(str)){
                    Toast.makeText(getApplicationContext(),str + "你好！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "用户名为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.submitbtn:
                if(rd2.isChecked()){
                    Toast.makeText(getApplicationContext(), "正确",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "错误",Toast.LENGTH_SHORT).show();
                }

        }
    }
}
