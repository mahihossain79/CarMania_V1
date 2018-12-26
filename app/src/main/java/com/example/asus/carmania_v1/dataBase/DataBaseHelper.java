package com.example.asus.carmania_v1.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sakib on 18-Jan-18.
 */

public class DataBaseHelper extends SQLiteOpenHelper
{
    public  static final  String DB_NAME = "student.db";

    public DataBaseHelper(Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
