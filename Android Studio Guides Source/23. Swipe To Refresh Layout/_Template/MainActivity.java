package com.as.androidstudiotutorials;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh_layout);
        final TextView textView = findViewById(R.id.textView);

        // set color
        refreshLayout.setColorSchemeColors(Color.BLACK);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                // your action when refresh layout swiped
                String text = "Refreshed!";

                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                textView.setText(text);

                refreshLayout.setRefreshing(false);
            }
        });


    }


}