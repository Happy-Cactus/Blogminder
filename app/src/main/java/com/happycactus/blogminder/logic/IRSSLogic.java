package com.happycactus.blogminder.logic;

import android.util.Xml;

import java.util.Calendar;

public interface IRSSLogic {
    Calendar LastPostDate(Xml Feed);
    boolean FeedValid(String FeedString);
    String GetFeedString(String FeedUrl);
}
