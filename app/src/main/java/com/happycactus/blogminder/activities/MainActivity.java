package com.happycactus.blogminder.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.happycactus.blogminder.R;
import com.happycactus.blogminder.logic.IApplicationLogic;
import com.happycactus.blogminder.logic.IRSSLogic;
import com.happycactus.blogminder.logic.LiveApplicationLogic;
import com.happycactus.blogminder.logic.LiveRSSLogic;
import com.happycactus.blogminder.receivers.RSSFeedCheckReceiver;
import com.happycactus.blogminder.repositories.IOptionsRepository;
import com.happycactus.blogminder.repositories.SQLiteOptionsRepository;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.MutableDateTime;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private final int MillisecondsInADay = 86400000;
    private IApplicationLogic mApplicationLogic;
    private IOptionsRepository mOptionsRepository;
    private IRSSLogic mRSSLogic;

    private Spinner mNewPostNeededSpinner;
    private EditText mNewPostRangeTextBox;
    private Spinner mCheckFrequencySpinner;
    private Spinner mCheckTimeHourSpinner;
    private Spinner mCheckTimeMinuteSpinner;
    private EditText mFeedUrlTextBox;
    private EditText mDateNodeTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApplicationLogic = new LiveApplicationLogic();
        mOptionsRepository = new SQLiteOptionsRepository(this);
        mRSSLogic = new LiveRSSLogic();

        mNewPostNeededSpinner = (Spinner) findViewById(R.id.newPostNeededSpinner);
        mNewPostRangeTextBox = (EditText) findViewById(R.id.dayRangeEditText);
        mCheckFrequencySpinner = (Spinner) findViewById(R.id.checkFrequencySpinner);
        mCheckTimeHourSpinner = (Spinner) findViewById(R.id.checkHourSpinner);
        mCheckTimeMinuteSpinner = (Spinner) findViewById(R.id.checkMinuteSpinner);
        mFeedUrlTextBox = (EditText) findViewById(R.id.feedUrlEditText);
        mDateNodeTextBox = (EditText) findViewById(R.id.dateNodeNameEditText);

        fillInUI();

        mApplicationLogic = new LiveApplicationLogic();
    }

    private void fillInUI(){
        //Fill in mNewPostNeededSpinner
        mNewPostRangeTextBox.setText(Integer.toString(mOptionsRepository.GetRange()));
        //Fill in mCheckFrequencySpinner
        //Fill in mCheckTimeHourSpinner
        //Fill in mCheckTimeMinuteSpinner
        mFeedUrlTextBox.setText(mOptionsRepository.GetRSSFeedUrl());
        mDateNodeTextBox.setText(mOptionsRepository.GetPublishDateNodeName());
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
