package com.azman.sundaypractice.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

//public class ServicesExample extends Service {

//IntentService stop services it self
public class ServicesExample extends IntentService {

    public ServicesExample( )
    {
        super("name");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Toast.makeText(this, "onHandleIntent method", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "onCreate Service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "onStartCommand Service", Toast.LENGTH_SHORT).show();
// stop automatically if services finish
//        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy Service", Toast.LENGTH_SHORT).show();
    }


}
