package com.happycactus.blogminder;

import java.util.Calendar;

/**
 * Created by antony on 13/01/16.
 */
public interface IOptionsRepository {
    Calendar GetNextDeadline(Calendar From, int NumberOfDays);
    void SetNextDeadLine(Calendar Deadline);
    String GetRSSFeedUrl();
    String SetRSSFeedUrl(String RSSFeedUrl);
}
