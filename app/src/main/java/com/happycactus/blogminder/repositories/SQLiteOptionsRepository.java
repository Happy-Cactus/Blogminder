package com.happycactus.blogminder.repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.happycactus.blogminder.database.OptionsDatabaseHelper;
import com.happycactus.blogminder.models.PostFrequency;

import org.joda.time.DateTime;

public class SQLiteOptionsRepository implements IOptionsRepository {

    OptionsDatabaseHelper mOptionsDatabaseHelper;

    public  SQLiteOptionsRepository(Context context){
        mOptionsDatabaseHelper = new OptionsDatabaseHelper(context);
    }

    @Override
    public DateTime GetNextDeadline() {
        SQLiteDatabase db = mOptionsDatabaseHelper.getReadableDatabase();

        Cursor cursor = db.query(OptionsDatabaseHelper.OPTIONS_TABLE,
                        new String[]{"Value"}, "Name = ?", new String[]{"Deadline"}, null, null, null);

        if(cursor.getCount() < 1){
            return null;
        }

        cursor.moveToFirst();
        DateTime deadline = new DateTime(cursor.getString(0));

        db.close();
        return deadline;
    }

    @Override
    public void SetNextDeadLine(DateTime Deadline) {

    }

    @Override
    public void SetPublishDateNodeName(String PublishDateNodeName) {

    }

    @Override
    public String GetPublishDateNodeName() {
        SQLiteDatabase db = mOptionsDatabaseHelper.getReadableDatabase();

        Cursor cursor = db.query(OptionsDatabaseHelper.OPTIONS_TABLE,
                new String[]{"Value"}, "Name = ?", new String[]{"NodeName"}, null, null, null);

        if(cursor.getCount() < 1){
            return null;
        }

        cursor.moveToFirst();
        String nodeName = cursor.getString(0);
        db.close();

        return nodeName;
    }

    @Override
    public String GetRSSFeedUrl() {
        SQLiteDatabase db = mOptionsDatabaseHelper.getReadableDatabase();

        Cursor cursor = db.query(OptionsDatabaseHelper.OPTIONS_TABLE,
                new String[]{"Value"}, "Name = ?", new String[]{"FeedUrl"}, null, null, null);

        if(cursor.getCount() < 1){
            return null;
        }

        cursor.moveToFirst();
        String feedUrl = cursor.getString(0);
        db.close();

        return feedUrl;
    }

    @Override
    public void SetRSSFeedUrl(String RSSFeedUrl) {

    }

    @Override
    public int GetRange() {
        SQLiteDatabase db = mOptionsDatabaseHelper.getReadableDatabase();

        Cursor cursor = db.query(OptionsDatabaseHelper.OPTIONS_TABLE,
                new String[]{"Value"}, "Name = ?", new String[]{"FeedUrl"}, null, null, null);

        if(cursor.getCount() < 1){
            return -1;
        }

        cursor.moveToFirst();
        int range = cursor.getInt(0);
        db.close();

        return range;
    }

    @Override
    public void SetRange(int Range) {

    }

    @Override
    public PostFrequency GetPostFrequency() {
        SQLiteDatabase db = mOptionsDatabaseHelper.getReadableDatabase();

        Cursor cursor = db.query(OptionsDatabaseHelper.OPTIONS_TABLE,
                new String[]{"Value"}, "Name = ?", new String[]{"Frequency"}, null, null, null);

        if(cursor.getCount() < 1){
            return null;
        }

        cursor.moveToFirst();
        int frequency = cursor.getInt(0);
        db.close();

        return getPostFrequencyFromInt(frequency);
    }

    @Override
    public void SetPostFrequency(PostFrequency Frequency) {

    }

    private PostFrequency getPostFrequencyFromInt(int Frequency){
        switch (Frequency){
            case 0:
                return PostFrequency.Weekly;

            case 1:
                return PostFrequency.Fortnightly;

            case 2:
                return PostFrequency.Monthly;

            default:
                return PostFrequency.Weekly;
        }
    }
}
