package com.example.littlekingsapp.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase loginDB) {

        loginDB.execSQL("create Table users(username Text primary key, password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase loginDB, int oldVersion, int newVersion) {
        loginDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase loginDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = loginDB.insert("users", null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase loginDB = this.getWritableDatabase();
        Cursor cursor = loginDB.rawQuery("select * from users where username = ?", new String [] {username});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkusernamePassword(String username,String password){
        SQLiteDatabase loginDB = this.getWritableDatabase();
        Cursor cursor = loginDB.rawQuery("select * from users where username = ? and password = ? ", new String [] {username, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
