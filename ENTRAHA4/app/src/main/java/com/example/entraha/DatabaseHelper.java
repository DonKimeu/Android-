package com.example.entraha;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="crud.db";

    public static final String TABLE_NAME="users";

    public static final String COL_1="username";
    public static final String COL_2="email";
    public static final String COL_3="password";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,1);
    }}
