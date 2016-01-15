package com.happycactus.blogminder;

import java.util.Calendar;

public interface IOptionsRepository {
    Calendar GetNextDeadline(Calendar From, int NumberOfDays);
    void SetNextDeadLine(Calendar Deadline);
    String GetRSSFeedUrl();
    String SetRSSFeedUrl(String RSSFeedUrl);
}
