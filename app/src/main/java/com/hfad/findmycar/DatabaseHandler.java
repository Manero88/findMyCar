package com.hfad.findmycar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "findMyCar.db";
    public static final String TABLE_NAME = "history_locations";

    public static final String COL_ID = "id INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String COL_LATLONG = "latlong TEXT";
    public static final String COL_ADDRES = "addres TEXT";
    public static final String COL_DATETIME = "datetime DATETIME";
    public static final String COL_PHOTOS_PATH = "photos_path TEXT";



    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("+ COL_ID +","+ COL_LATLONG+","+ COL_DATETIME +","+ COL_PHOTOS_PATH +", "+ COL_ADDRES +")";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String latlong, String addres, String dateTime, String imagesPath){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ADDRES, addres);
        contentValues.put(COL_DATETIME, dateTime);
        contentValues.put(COL_LATLONG, latlong);
        contentValues.put(COL_PHOTOS_PATH, imagesPath);

        if(db.insert(TABLE_NAME, null, contentValues ) < 1){
            return false;
        }else{
            return true;
        }
    };



}
