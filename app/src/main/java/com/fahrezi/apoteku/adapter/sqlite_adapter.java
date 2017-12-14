package com.fahrezi.apoteku.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by fahrezi on 12/12/17.
 */

public class sqlite_adapter extends SQLiteOpenHelper {
    public sqlite_adapter(Context context) {
        super(context, "apoteku.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE auth(username TEXT PRIMARY KEY,password TEXT,level INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS auth");
        onCreate(db);
    }

    public boolean login(String username, String password, int level) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        cv.put("level", level);
        long cek = db.insert("auth", null, cv);
        if (cek == 0)
            return false;
        else
            return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor cek_login() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM auth", null, null);
        return c;
    }

    public boolean logout(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("auth", "username=?", new String[]{username}) > 0;
    }

}
