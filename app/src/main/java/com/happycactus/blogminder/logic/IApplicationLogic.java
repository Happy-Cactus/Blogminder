package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;

public interface IApplicationLogic {
    boolean IsLastPostDateBeforeNextDeadLine(DateTime LastPost, DateTime Deadline);
    long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime);
}
