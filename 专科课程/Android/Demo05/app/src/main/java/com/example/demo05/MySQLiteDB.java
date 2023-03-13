package com.example.demo05;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MySQLiteDB {
    DBHelper helper;
    static final String DB_NAME = "userinfo.db";
    static final String TB_NAME = "users";
    SQLiteDatabase db;
    Context context;
    static final String CREATE_TABLE = "create table users (" +
            "id integer primary key autoincrement," +
            "name text not null," +
            "password text not null," +
            "phone text not null);";

    //创建数据库
    public void create(Context c) {
        context = c;
        helper = new DBHelper(context,DB_NAME,null,1);
        db = helper.getWritableDatabase();
    }

    //删除数据库
    public void deleteDB() {
        context.deleteDatabase(DB_NAME);
        Log.d("Main","删库成功");
    }

    //添加数据
    public void insertInfo() {
        ContentValues values = new ContentValues();
        values.put("name","李爽");
        values.put("password","123456");
        values.put("phone","18982379506");
        db.insert(TB_NAME,null,values);
        Log.d("Main","添加成功");
    }

    //删除数据
    public void deleteInfo() {
        db.delete(TB_NAME,"name = '李爽'",null);
    }

    //更新数据
    public void updateInfo() {
        ContentValues values = new ContentValues();
        values.put("password","123456");
        db.update(TB_NAME,values,"name = '李爽'",null);
    }

    //查询数据
    public void queryInfo() {
        Cursor cursor = db.rawQuery("select * from users",null);
        if (cursor.moveToFirst()) {
            do{
              String name = cursor.getString(cursor.getColumnIndex("name"));
              String pwd = cursor.getString(cursor.getColumnIndex("password"));
              Log.d("Main","用户名：" + name + "密码" + pwd);
            }while (cursor.moveToNext());
        }

        cursor.close();
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
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
