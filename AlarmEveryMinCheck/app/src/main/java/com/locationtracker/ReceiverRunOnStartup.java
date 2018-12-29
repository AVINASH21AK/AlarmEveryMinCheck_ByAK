package com.locationtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;



public class ReceiverRunOnStartup extends BroadcastReceiver {

    String TAG = "ReceiverRunOnStartup";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            App.showLog(TAG, "Phone restarted or boot completed.");
            App.startAlarmServices(context);
        }
    }

}