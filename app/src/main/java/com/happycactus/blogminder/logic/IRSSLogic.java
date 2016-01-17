package com.happycactus.blogminder.logic;

import com.happycactus.blogminder.models.RSSFeed;

import java.util.Calendar;

public interface IRSSLogic {
    Calendar LastPostDate(RSSFeed Feed);
    boolean FeedValid(String FeedString);
    RSSFeed GetRSSFeed(String FeedUrl);


}
