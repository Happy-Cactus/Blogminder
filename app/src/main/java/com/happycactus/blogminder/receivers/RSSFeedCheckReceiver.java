package com.happycactus.blogminder.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.happycactus.blogminder.R;
import com.happycactus.blogminder.activities.MainActivity;
import com.happycactus.blogminder.logic.IApplicationLogic;
import com.happycactus.blogminder.logic.IRSSLogic;
import com.happycactus.blogminder.logic.LiveApplicationLogic;
import com.happycactus.blogminder.logic.LiveRSSLogic;
import com.happycactus.blogminder.models.RSSFeed;
import com.happycactus.blogminder.repositories.IOptionsRepository;
import com.happycactus.blogminder.repositories.SQLiteOptionsRepository;

import org.joda.time.DateTime;


public class RSSFeedCheckReceiver extends BroadcastReceiver {
    private String mContentTitle = "WRITE A POST!";
    private String mContentText = "You haven't posted any content in a while";
    private IApplicationLogic mApplicationLogic;
    private IRSSLogic mRSSLogic;
    private IOptionsRepository mOptionsRepository;

    @Override
    public void onReceive(Context context, Intent intent) {
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

        mApplicationLogic = new LiveApplicationLogic();
        mRSSLogic = new LiveRSSLogic();
        mOptionsRepository = new SQLiteOptionsRepository(context);

        String feedUrl = mOptionsRepository.GetRSSFeedUrl();
        String nodeName = mOptionsRepository.GetPublishDateNodeName();
        RSSFeed feed = mRSSLogic.GetRSSFeed(feedUrl, nodeName);
        DateTime lastPostDate = mRSSLogic.LastPostDate(feed);
        DateTime deadline = mOptionsRepository.GetNextDeadline();
        int range = mOptionsRepository.GetRange();

        if(mApplicationLogic.newPostNeeded(lastPostDate, deadline, range)){
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(mContentTitle)
                            .setContentText(mContentText);
            mBuilder.setContentIntent(contentIntent);
            mBuilder.setDefaults(Notification.DEFAULT_SOUND);
            mBuilder.setAutoCancel(true);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());
        }
    }
}
