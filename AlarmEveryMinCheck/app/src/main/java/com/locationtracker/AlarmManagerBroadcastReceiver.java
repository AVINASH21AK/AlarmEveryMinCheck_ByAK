package com.locationtracker;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    final public static String ONE_TIME = "onetime";
    Context mContext;


    String TAG = "===---AlarmManagerBroadcastReceiver---===";

    @Override
    public void onReceive(Context context, Intent intent) {

        App.showLog(TAG , "onReceive");

        mContext = context;

        if (mContext == null) {
            mContext = App.context;
        }


        //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        //wl.acquire();
        Bundle extras = intent.getExtras();
        StringBuilder msgStr = new StringBuilder();

        if (extras != null && extras.getBoolean(ONE_TIME, Boolean.FALSE)) {
            //Make sure this intent has been sent by the one-time timer button.
            msgStr.append("One time Timer : ");
        }


        Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

        msgStr.append(formatter.format(new Date()));




        //wl.release();
    }

    public void SetAlarm(Context context) {
        App.showLog(TAG, "SetAlarm");
        mContext = context;
        //  strPrevTime = "";
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);

        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 20, alarmIntent);
    }

    public void CancelAlarm(Context context) {
        App.showLog(TAG, "CancelAlarm");
        mContext = context;
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }


}
