package com.happycactus.blogminder.logic;

import java.util.Calendar;

public interface IRSSLogic {
    Calendar LastPostDate(String FeedUrl);
    boolean FeedValid(String FeedUrl);
}
