package com.azman.sundaypractice.navigationdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.azman.sundaypractice.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerExample extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_example);

        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                // Navigation drawer item click listener
                switch (item.getItemId()) {
                    case R.id.android:

                        //Replace your own action here
                        Toast.makeText(NavigationDrawerExample.this, "Android", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mail:

                        //Replace your own action here
                        Toast.makeText(NavigationDrawerExample.this, "Mail", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:

                        //Replace your own action here
                        Toast.makeText(NavigationDrawerExample.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate:

                        //Replace your own action here
                        Toast.makeText(NavigationDrawerExample.this, "Rate", Toast.LENGTH_SHORT).show();

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        toolbar.setTitle("Navigation Drawer Example");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // If you need to set image to navigation header image or setText for header textView follow the  code below

        View headerView = navigationView.getHeaderView(0);

        TextView textView = headerView.findViewById(R.id.header_textView);
        ImageView imageView = headerView.findViewById(R.id.header_imageView);

        // Set navigation header text
        textView.setText("Android Studio Tutorials");

        // Set navigation header image
        imageView.setImageResource(R.mipmap.ic_launcher);


    }
}