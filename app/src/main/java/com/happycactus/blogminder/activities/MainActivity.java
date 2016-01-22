package com.happycactus.blogminder.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.happycactus.blogminder.R;
import com.happycactus.blogminder.logic.IApplicationLogic;
import com.happycactus.blogminder.logic.LiveApplicationLogic;
import com.happycactus.blogminder.receivers.RSSFeedCheckReceiver;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.MutableDateTime;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private final int MillisecondsInADay = 86400000;
    private IApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApplicationLogic = new LiveApplicationLogic();
    }

    public void setAlarm(View v){
        DateTime now = DateTime.now();
        MutableDateTime target = MutableDateTime.now();
        target.addDays(1);
        target.setTime(8, 0, 0, 0);

        Intent alarmIntent = new Intent(this, RSSFeedCheckReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                mApplicationLogic.getMillisecondsBetweenTimes(target.toDateTime(), now),
                MillisecondsInADay, //Milliseconds in one day.
                PendingIntent.getBroadcast(this, 1, alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_LONG).show();
    }

    public void cancelAlarm(View v){
        Intent alarmIntent = new Intent(this, RSSFeedCheckReceiver.class);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.cancel(PendingIntent.getBroadcast(this, 1, alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this, "Alarm Unscheduled", Toast.LENGTH_LONG).show();
    }
}
