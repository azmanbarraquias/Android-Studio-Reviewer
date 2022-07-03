package com.azman.myandroidstudioguides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, RecyclerViewSample.class);

        //        String  message = "Hello World";
        //        intent.putExtra("MessageKey", message);

        startActivity(intent);
    }
}