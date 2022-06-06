package com.azman.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListItem[] listItems = {
                new ListItem("Item 1", android.R.drawable.sym_def_app_icon),
                new ListItem("Item 2", R.drawable.ic_launcher_foreground),
                new ListItem("Item 3", android.R.drawable.presence_video_busy)
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.customListView);
        CustomListItem customListItem = new CustomListItem(getApplication(), listItems);
        listView.setAdapter(customListItem);
    }
}