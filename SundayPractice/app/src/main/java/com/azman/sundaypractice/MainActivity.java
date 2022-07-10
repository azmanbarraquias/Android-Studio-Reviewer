package com.azman.sundaypractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.azman.sundaypractice.broadcast_receiver.BroadcastExample;
import com.azman.sundaypractice.fragmenttest.BasicFragmentMain;
import com.azman.sundaypractice.fragmenttest.fragment1;
import com.azman.sundaypractice.fragmenttest.fragment2;
import com.azman.sundaypractice.fragmenttest.fragment3;
import com.azman.sundaypractice.services.ServicesLifeCycle;

public class MainActivity extends AppCompatActivity {

    Button firstFragmentBtn;
    Button secondFragmentBtn;
    Button thirdFragmentBtn;
    FrameLayout mFrameLayout;

    BroadcastExample receiver = new BroadcastExample();
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        this.registerReceiver(receiver, intentFilter);

        startActivity(new Intent(MainActivity.this, OptionMenuExample.class));

    }

    @Override
    protected void onStop() {
        super.onStop();
        MainActivity.this.unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.registerReceiver(receiver, intentFilter);
    }
}
