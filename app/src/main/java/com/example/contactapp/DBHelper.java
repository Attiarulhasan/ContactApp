package com.example.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
     DB.execSQL("create Table Userdetails(name TEXT primary key,email TEXT,number TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
      DB.execSQL("drop table if exists USerdetails");
    }
    public boolean insertData(String name, String email, String number){
        SQLiteDatabase Db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("number",number);
        long result=Db.insert("Userdetails",null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase Db= this.getWritableDatabase();
        Cursor cursor= Db.rawQuery("Select * from Userdetails",null);
        return cursor;
    }
}
