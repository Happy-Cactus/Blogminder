package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;

public interface IApplicationLogic {
    boolean newPostNeeded(DateTime LastPost, DateTime Deadline, int Range);
    long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime);
}
