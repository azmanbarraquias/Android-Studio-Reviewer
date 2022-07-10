package com.azman.sundaypractice.broadcast_receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class BroadcastExample extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if (isAirplaneModeOn)
            Toast.makeText(context, "Device in airplane mode on", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, "Device in airplane mode off", Toast.LENGTH_LONG).show();


    }
}
