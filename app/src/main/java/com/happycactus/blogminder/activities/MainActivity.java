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

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View v){
        Long time = new GregorianCalendar().getTimeInMillis() + 60 * 1000;

        Intent alarmIntent = new Intent(this, RSSFeedCheckReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, time,
                PendingIntent.getBroadcast(this, 1, alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this, "Alarm Scheduled for 1 min", Toast.LENGTH_LONG).show();
    }
}
