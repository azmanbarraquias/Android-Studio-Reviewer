package com.azman.sundaypractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

public class ToolBarExample extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_example);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set Title
        getSupportActionBar().setTitle("Toolbar Example");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {

        // add event for back button pressed
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
        return true;
    }
}