package com.azman.myandroidstudioguides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewSample extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterManager recyclerAdapterManager;

    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sample);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // add item
        items.add(new Item("item 1",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem, quia?",
                R.drawable.ic_launcher_background));

        items.add(new Item("item 2",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem, quia?",
                R.drawable.ic_launcher_background));

        items.add(new Item("item 3",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem, quia?",
                R.drawable.ic_launcher_background));

        // create adapter
        recyclerAdapterManager = new RecyclerAdapterManager(items, this);

        // set adapter to view
        recyclerView.setAdapter(recyclerAdapterManager);
    }
}