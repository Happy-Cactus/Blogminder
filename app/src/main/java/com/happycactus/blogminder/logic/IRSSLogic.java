package com.happycactus.blogminder.logic;

import com.happycactus.blogminder.models.RSSFeed;
import com.happycactus.blogminder.repositories.IOptionsRepository;

import org.joda.time.DateTime;

public interface IRSSLogic {
    DateTime LastPostDate(RSSFeed Feed);
    boolean FeedValid(String FeedString);
    RSSFeed GetRSSFeed(String FeedUrl, String NodeName);


}
