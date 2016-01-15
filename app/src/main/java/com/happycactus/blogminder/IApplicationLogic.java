package com.happycactus.blogminder;

import java.util.Calendar;

public interface IApplicationLogic {
    boolean IsLastPostDateBeforeNextDeadLine(Calendar LastPost, Calendar DeadLine);
}
