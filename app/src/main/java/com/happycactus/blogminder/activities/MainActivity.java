package com.happycactus.blogminder.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.happycactus.blogminder.R;
import com.happycactus.blogminder.receivers.RSSFeedCheckReceiver;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.MutableDateTime;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View v){
        Long time = new GregorianCalendar().getTimeInMillis() + 60 * 1000;

        DateTime now = DateTime.now();
        MutableDateTime target = MutableDateTime.now();
        target.addDays(1);
        target.setTime(8, 0, 0, 0);

        Duration timeUntil8am = new Duration(now, target);

        Intent alarmIntent = new Intent(this, RSSFeedCheckReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                timeUntil8am.getMillis(),
                1000 * 60 * 60 * 24, //Milliseconds in one day.
                PendingIntent.getBroadcast(this, 1, alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this, "Alarm Scheduled for 1 min", Toast.LENGTH_LONG).show();
    }

    public void cancelAlarm(View v){
        Intent alarmIntent = new Intent(this, RSSFeedCheckReceiver.class);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.cancel(PendingIntent.getBroadcast(this, 1, alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
