package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.Calendar;

public class LiveApplicationLogic implements IApplicationLogic {


    @Override
    public boolean newPostNeeded(DateTime LastPost, DateTime Deadline, int Range) {
        return false;
    }

    @Override
    public long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime) {
        return new Duration(FromTime, TargetTime).getMillis();
    }
}
