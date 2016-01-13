package com.happycactus.blogminder;

import java.util.Calendar;

/**
 * Created by antony on 13/01/16.
 */
public class LiveRSSLogic implements IRSSLogic{
    @Override
    public Calendar LastPostDate(String FeedUrl) {
        return null;
    }

    @Override
    public boolean FeedValid(String FeedUrl) {
        return false;
    }
}
