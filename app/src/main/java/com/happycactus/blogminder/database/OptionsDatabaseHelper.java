package com.happycactus.blogminder.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OptionsDatabaseHelper extends SQLiteOpenHelper {
    private static final String db_name = "blogminder_options";
    private static final int db_version = 1;

    public static final String OPTIONS_TABLE = "OPTIONS";

    public OptionsDatabaseHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
                    OPTIONS_TABLE +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Name TEXT," +
                    "Value TEXT);");

        insertOption(db, "TimeToCheck", "0800"); //Default to 8 am
        insertOption(db, "Interval", Integer.toString(1000 * 60 * 60 * 24)); //Default to once a day
        insertOption(db, "FeedUrl", "http://antonychurch.co.uk/blog/feed");
        insertOption(db, "Range", "2");
        insertOption(db, "NodeName", "dc:date");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertOption(SQLiteDatabase db, String OptionName, String OptionValue){
        db.execSQL("INSERT INTO " +
                OPTIONS_TABLE +
                " (Name, Value) " +
                "VALUES (" +
                OptionName + "," +
                OptionValue + ");");
    }
}
