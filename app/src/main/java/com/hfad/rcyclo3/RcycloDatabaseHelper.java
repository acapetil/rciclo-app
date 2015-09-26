package com.hfad.rcyclo3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class RcycloDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "rcyclo";
    private static final int DB_VERSION = 1;

    RcycloDatabaseHelper(Context context){ super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ESTABLISHMENT (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "EMAIL TEXT, " + "PASSWORD TEXT, " + "PHONE TEXT, " + "ADDRESS TEXT, " + "WASTE TEXT);");
        db.execSQL("CREATE TABLE COMPANY       (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "EMAIL TEXT, " + "PASSWORD TEXT, " + "PHONE TEXT, " + "ADDRESS TEXT);");
        db.execSQL("CREATE TABLE CONTAINER     (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "LAT TEXT, " + "LON TEXT, "  + "ESTABLISHMENT TEXT, " + "COMPANY TEXT, " + "ACTIVO TEXT, " + "ESTADO TEXT);");

    //    insertEstablishment(db, "San Jose", "sanjose@gmail.com", "admin", "6032708", "santiago", "papel");
        //       insertEstablishment(db, "Carlangas", "gmail", "qwerty", "124354", "valparaiso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    public static void  insertEstablishment(SQLiteDatabase db, String name, String email, String password, String phone, String address, String waste) {
        ContentValues establishmentValues = new ContentValues();
        establishmentValues.put("NAME", name);
        establishmentValues.put("EMAIL", email);
        establishmentValues.put("PASSWORD", password);
        establishmentValues.put("PHONE", phone);
        establishmentValues.put("ADDRESS", address);
        establishmentValues.put("WASTE", waste);
        db.insert("ESTABLISHMENT", null, establishmentValues);
    }


}
