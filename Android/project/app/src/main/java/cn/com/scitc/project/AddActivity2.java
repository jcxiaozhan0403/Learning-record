package cn.com.scitc.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity2 extends AppCompatActivity {
    private MySQLiteDB mySQLiteDB = new MySQLiteDB();
    private Button save,cacel;
    private EditText title,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        save = findViewById(R.id.save);
        cacel = findViewById(R.id.cacel);
        title = findViewById(R.id.title);
        text = findViewById(R.id.text);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQLiteDB.insert(title.getText().toString(),text.getText().toString());
            }
        });

        cacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}