package com.happycactus.blogminder.logic;

import java.util.Calendar;

public class LiveApplicationLogic implements IApplicationLogic {
    @Override
    public boolean IsLastPostDateBeforeNextDeadLine(Calendar LastPost, Calendar Deadline) {
        //If LastPost or Deadline is null return true.
        //This will stop the application notifying the user every time the alarm is checked.
        if(LastPost == null){
            return true;
        }
        else if(Deadline == null){
            return true;
        }
        else{
            return LastPost.before(Deadline);
        }
    }
}
