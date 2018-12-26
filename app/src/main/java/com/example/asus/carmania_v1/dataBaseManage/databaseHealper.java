package com.example.asus.carmania_v1.dataBaseManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.carmania_v1.modelClass.Users;

import java.util.ArrayList;

/**
 * Created by sakib on 23-Feb-18.
 */

public class databaseHealper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "customer.db";

    public databaseHealper(Context context) {
        super(context, DATABASE_NAME ,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tableAttributes obj = new tableAttributes();
        String tableCreateQuery = obj.createTable();

        try
        {
            sqLiteDatabase.execSQL(tableCreateQuery);
            Log.i("Success","DATABASE Created Successfully");
        }
        catch (SQLException e)
        {
            Log.e("ERROR",e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }

    public void dataEntry(Users user) {

        ContentValues values = new ContentValues();

        values.put(tableAttributes.USER_FIRSTNAME, user.getFirstName());
        values.put(tableAttributes.USER_LASTNAME, user.getLastName());
        values.put(tableAttributes.USER_PHONE,user.getPhone());
        values.put(tableAttributes.USER_EMAIL,user.getEmail());
        values.put(tableAttributes.USER_PASSWORD,user.getPassword());
        /*values.put(tableAttributes.USER_CONFIRM_PASSWORD,user.getConfirmPassword());*/

        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.insert(tableAttributes.TABLE_NAME,null,values);
            Log.i("Success","Data Entered Successfully");
        }
        catch (SQLException e)
        {
            Log.e("Error",e.toString());
        }
    }

    public Users getUserInfo(){
        Users user = null;

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + tableAttributes.TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){

            while (!cursor.isAfterLast()){
                user = new Users();

                user.setFirstName(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_FIRSTNAME)));
                user.setLastName(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_LASTNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_PASSWORD)));
                /*user.setConfirmPassword(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_CONFIRM_PASSWORD)));
                */user.setPhone(cursor.getString(cursor.getColumnIndex(tableAttributes.USER_PHONE)));


                cursor.moveToNext();
            }
        }




        return user;
    }

/*
    public Boolean dataUpdateQuery(Student std,String oldName){

        ContentValues value = new ContentValues();

        value.put(tableAttributes.STUDENT_NAME,std.getName());
        value.put(tableAttributes.STUDENT_PASSWORD,std.getPassword());
        value.put(tableAttributes.STUDENT_CGPA,std.getCgpa());
        value.put(tableAttributes.STUDENT_EMAIL,std.getEmail());
        value.put(tableAttributes.STUDENT_PHONE,std.getPhoneNo());
        value.put(tableAttributes.STUDENT_ADDRESS,std.getAddress());

        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.update(tableAttributes.TABLE_NAME,value,tableAttributes.STUDENT_NAME + " = ? ",new String[] {oldName});
            Log.i("Updated","DONE" + tableAttributes.STUDENT_ID);
            return  true;
        }
        catch (SQLiteException e) {
            Log.i("Error",e.toString());
            return false;
        }
    }
*/
}
