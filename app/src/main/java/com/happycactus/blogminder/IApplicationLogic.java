package com.happycactus.blogminder;

import java.util.Calendar;

/**
 * Created by antony on 13/01/16.
 */
public interface IApplicationLogic {
    boolean IsLastPostDateBeforeNextDeadLine(Calendar LastPost, Calendar DeadLine);
}
