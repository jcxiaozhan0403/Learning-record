package cn.com.scitc.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private ListView mLv1;
    private MySQLiteDB mySQLiteDB = new MySQLiteDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLiteDB.create(this);
        mLv1 = findViewById(R.id.lv_1);
        mLv1.setAdapter(new MyListAdapter(this));

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity2.class);
                startActivity(intent);
            }
        });
    }
}