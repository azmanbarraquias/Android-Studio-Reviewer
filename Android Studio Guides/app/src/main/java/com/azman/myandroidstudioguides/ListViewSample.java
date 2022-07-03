package com.azman.myandroidstudioguides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewSample extends AppCompatActivity {
    ListView listView;
    String[] items;
    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample);
        listView = findViewById(R.id.listView);
        items = getResources().getStringArray(R.array.Items);

        // Adapter connect datasource to a view
        // new ArrayAdapter<String>("Where you want to this adapter to work (this class), listview layout
        // android.R.layout.simple_list_item_1 predefined layout
        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(stringArrayAdapter);

        Intent intent = getIntent();
        String message = intent.getStringExtra("MessageKey");
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}