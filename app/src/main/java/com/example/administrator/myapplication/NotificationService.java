package com.example.administrator.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

/**
 * Created by Administrator on 2017/5/19.
 */

public class NotificationService extends IntentService {

    public NotificationService(){
        super("notification");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Notification.Builder builder=new Notification.Builder(this);
        int requestCode=(int) System.currentTimeMillis();
        Intent myIntent=new Intent(this,NotiActivity.class);
        int flags= PendingIntent.FLAG_CANCEL_CURRENT;
        PendingIntent pIntent=PendingIntent.getActivity(this,requestCode,myIntent,flags);
        builder.setContentTitle("title").setContentText("Hello").setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pIntent).setAutoCancel(true);
        NotificationManager notiManger=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notiManger.notify(requestCode,builder.build());
    }
}
