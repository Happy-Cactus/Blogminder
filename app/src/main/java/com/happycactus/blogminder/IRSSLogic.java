package com.happycactus.blogminder;

import java.util.Calendar;

/**
 * Created by antony on 13/01/16.
 */
public interface IRSSLogic {
    Calendar LastPostDate(String FeedUrl);
    boolean FeedValid(String FeedUrl);
}
