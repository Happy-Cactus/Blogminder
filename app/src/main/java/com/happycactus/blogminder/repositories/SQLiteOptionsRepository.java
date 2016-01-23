package com.happycactus.blogminder.repositories;

import android.content.Context;

import com.happycactus.blogminder.database.OptionsDatabaseHelper;

import org.joda.time.DateTime;

public class SQLiteOptionsRepository implements IOptionsRepository {

    OptionsDatabaseHelper mOptionsDatabaseHelper;

    public  SQLiteOptionsRepository(Context context){
        mOptionsDatabaseHelper = new OptionsDatabaseHelper(context);
    }

    @Override
    public DateTime GetNextDeadline(DateTime From, int NumberOfDays) {
        return null;
    }

    @Override
    public void SetNextDeadLine(DateTime Deadline) {

    }

    @Override
    public void SetPublishDateNodeName(String PublishDateNodeName) {

    }

    @Override
    public String GetPublishDateNodeName() {
        return null;
    }

    @Override
    public String GetRSSFeedUrl() {
        return null;
    }

    @Override
    public void SetRSSFeedUrl(String RSSFeedUrl) {

    }

    @Override
    public int GetRange() {
        return 0;
    }

    @Override
    public void SetRange(int Range) {

    }
}
