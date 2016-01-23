package com.happycactus.blogminder.repositories;

import com.happycactus.blogminder.models.PostFrequency;

import org.joda.time.DateTime;

public interface IOptionsRepository {
    DateTime GetNextDeadline(DateTime From, int NumberOfDays);
    void SetNextDeadLine(DateTime Deadline);
    void SetPublishDateNodeName(String PublishDateNodeName);
    String GetPublishDateNodeName();
    String GetRSSFeedUrl();
    void SetRSSFeedUrl(String RSSFeedUrl);
    int GetRange();
    void SetRange(int Range);
    PostFrequency GetPostFrequency();
    void SetPostFrequency(PostFrequency Frequency);
}
