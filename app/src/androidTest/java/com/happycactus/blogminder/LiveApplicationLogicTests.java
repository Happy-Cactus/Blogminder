package com.happycactus.blogminder;

import com.happycactus.blogminder.logic.IApplicationLogic;
import com.happycactus.blogminder.logic.LiveApplicationLogic;

import junit.framework.TestCase;

import org.joda.time.DateTime;

public class LiveApplicationLogicTests extends TestCase {
    void testMillisecondsAreReturnedCorrectly(){

        //Setup
        IApplicationLogic logic = new LiveApplicationLogic();
        DateTime fakeNow = new DateTime(2016, 1, 1, 1, 0);
        DateTime targetTime = new DateTime(2016, 1, 1, 8, 0);
        long sevenHoursInMillis = 1000 * 60 * 60 * 7;

        //Assert
        assertTrue(logic != null);
        assertTrue(fakeNow != null);
        assertTrue(targetTime != null);

        assertTrue(fakeNow.getYear() == 2016);
        assertTrue(fakeNow.getMonthOfYear() == 1);
        assertTrue(fakeNow.getDayOfMonth() == 1);
        assertTrue(fakeNow.getHourOfDay() == 1);
        assertTrue(fakeNow.getMinuteOfHour() == 0);

        assertTrue(targetTime .getYear() == 2016);
        assertTrue(targetTime .getMonthOfYear() == 1);
        assertTrue(targetTime .getDayOfMonth() == 1);
        assertTrue(targetTime .getHourOfDay() == 8);
        assertTrue(targetTime .getMinuteOfHour() == 0);

        assertTrue(sevenHoursInMillis == 25200000);

        //Test Logic
        long logicAnswer = logic.getMillisecondsBetweenTimes(targetTime, fakeNow);
        assertTrue(sevenHoursInMillis == logicAnswer);
    }

    void testDeadLineLogic(){

        //Setup
        IApplicationLogic logic = new LiveApplicationLogic();
        DateTime deadline = new DateTime(2016, 1, 1, 1, 0);
        DateTime beforeDeadline = new DateTime(2015, 12, 1, 1, 0);
        DateTime afterDeadline = new DateTime(2015, 1, 2, 1, 0);
    }
}
