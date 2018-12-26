package com.example.asus.carmania_v1.dataBaseManage;

/**
 * Created by sakib on 23-Feb-18.
 */

public class tableAttributes {

    public static final String TABLE_NAME = "CUSTOMERS";
    public static final String USER_ID = "id";
    public static final String USER_FIRSTNAME = "first_name";
    public static final String USER_LASTNAME = "last_name";
    public static final String USER_PHONE = "phone";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_CONFIRM_PASSWORD = "confirm_password";


    public String createTable(){

        String query = "CREATE TABLE " + TABLE_NAME + "( " + USER_ID + " INTEGER AUTO INCREMENT PRIMARY KEY, " +
                USER_FIRSTNAME + " TEXT, " + USER_LASTNAME + " TEXT, " + USER_PHONE + " TEXT, " + USER_EMAIL + " TEXT, "
                + USER_PASSWORD + " TEXT, " + USER_CONFIRM_PASSWORD + " TEXT );";

        return query;
    }
}
