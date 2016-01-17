package com.happycactus.blogminder.logic;

import com.happycactus.blogminder.models.RSSItem;

import java.util.Calendar;

public interface IRSSLogic {
    Calendar LastPostDate(RSSItem item);
    boolean FeedValid(String FeedString);
    String GetFeedString(String FeedUrl);
}
