package cn.com.scitc.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MySQLiteDB {
    Date date;
    DBHelper helper;
    Context context;
    SQLiteDatabase db;
    static final String DB_NAME = "diary.db";
    static final String TB_NAME = "diary";
    static final int VERSION_CODE = 1;
    static final String CREATE_TABLE = "create table diary (" +
            "id integer primary key autoincrement," +
            "title varcher(10) not null," +
            "text varcher(255) not null," +
            "date datetime not null);";

    //创建数据库
    public void create(Context c) {
        context = c;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    //添加数据
    public void insert(String title,String text) {
        date = new Date();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("text",text);
        values.put("date", String.valueOf(date));
        db.insert(TB_NAME,null,values);
        Log.d("Main","添加成功");
    }

    //删除数据
    public void deleteInfo() {

    }

    //更新数据
    public void updateInfo() {

    }

    //查询数据
    public List query() {
        List<HashMap> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from diary",null);
        if (cursor.moveToFirst()) {
            do{
                HashMap map = new HashMap();
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String text = cursor.getString(cursor.getColumnIndex("text"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                map.put("title",title);
                map.put("text",text);
                map.put("date",date);
                list.add(map);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(@Nullable Context context) {
            super(context, DB_NAME, null, VERSION_CODE);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            Log.d("Main","建表成功");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
