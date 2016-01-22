package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;

import java.util.Calendar;

public class LiveApplicationLogic implements IApplicationLogic {

    @Override
    public boolean IsLastPostDateBeforeNextDeadLine(DateTime LastPost, DateTime Deadline) {
        if(LastPost == null){
            return true;
        }
        else if(Deadline == null){
            return true;
        }
        else{
            return LastPost.isBefore(Deadline);
        }
    }

    @Override
    public long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime) {
        return 0;
    }
}
