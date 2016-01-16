package com.happycactus.blogminder.logic;

import java.util.Calendar;

public interface IApplicationLogic {
    boolean IsLastPostDateBeforeNextDeadLine(Calendar LastPost, Calendar Deadline);
}
