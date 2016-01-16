package com.happycactus.blogminder.logic;

import java.util.Calendar;

public class LiveApplicationLogic implements IApplicationLogic {
    @Override
    public boolean IsLastPostDateBeforeNextDeadLine(Calendar LastPost, Calendar DeadLine) {
        return false;
    }
}
