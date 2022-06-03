package com.azman.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String[] listItems = {"Item 1", "Item 2", "Item 3"};
        int[] itemImages = {R.drawable.ic_launcher_foreground,  R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapater customBaseAdapater = new CustomBaseAdapater(getApplication(), listItems, itemImages);
        listView.setAdapter(customBaseAdapater);
    }
}