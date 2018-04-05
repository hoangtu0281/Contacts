package com.example.hoangtu.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HoangTu on 04/04/2018.
 */

public class DBMaganer extends SQLiteOpenHelper {

    private final String TAG = "DBMaganer";

    private static final String DATABASE_NAME = "contacts_manager";
    private static final String TABLE_NAME = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SEX = "gioiTinh";
    private static final String SDT = "sdt";
    private static int VESTION = 1;

   // public Contact contact;

    private static final String SQLQuery =" CREATE TABLE " +TABLE_NAME+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            NAME + " TEXT, "+
            SEX + " TEXT, "+
            SDT + " TEXT)";
    public DBMaganer(Context context) {
        super(context, DATABASE_NAME, null, VESTION);
        Log.d(TAG,"DBMaganer: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG,"onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,contact.getHoTen());
        values.put(SEX,contact.getGioiTinh());
        values.put(SDT,contact.getSdt());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
        Log.d(TAG,"database: lưu thành công ");

    }
}
