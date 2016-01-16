package com.happycactus.blogminder.logic;

import android.util.Xml;

import java.util.Calendar;

public class LiveRSSLogic implements IRSSLogic{
    @Override
    public Calendar LastPostDate(Xml Feed) {
        return null;
    }

    @Override
    public boolean FeedValid(Xml Feed) {
        return false;
    }

    @Override
    public Xml GetFeed(String FeedUrl) {
        return null;
    }
}
