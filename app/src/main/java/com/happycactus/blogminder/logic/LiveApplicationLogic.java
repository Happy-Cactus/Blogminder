package com.happycactus.blogminder.logic;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class LiveApplicationLogic implements IApplicationLogic {

    @Override
    public boolean newPostNeeded(DateTime LastPost, DateTime Deadline, int Range) {

        if(LastPost.isBefore(Deadline)){
            Duration difference = new Duration(LastPost, Deadline);
            //If the last post was within the range, return true.
            if(difference.getStandardDays() < Range){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return true;
        }
    }

    @Override
    public DateTime getNewDeadline(DateTime CurrentDateTime, int Interval) {
        return null;
    }

    @Override
    public long getMillisecondsBetweenTimes(DateTime TargetTime, DateTime FromTime) {
        return new Duration(FromTime, TargetTime).getMillis();
    }
}
