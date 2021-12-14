package com.cookandroid.movievoting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBHelper extends SQLiteOpenHelper {
    public myDBHelper(Context context){
        super(context,"movieDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE movieTBL (movieTitle CHAR(45) PRIMARY KEY, likeNum INTEGER);");
        for (int i=0;i<20;i++){
            db.execSQL("INSERT INTO movieTBL VALUES ( '제목 "+(i+1)+"', 0);");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS movieTBL");
        onCreate(db);
    }
}