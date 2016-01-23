package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;

public interface IApplicationLogic {
    boolean newPostNeeded(DateTime LastPost, DateTime Deadline, int Range);
    DateTime getNewDeadline(DateTime CurrentDateTime, int Interval);
    long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime);
}
