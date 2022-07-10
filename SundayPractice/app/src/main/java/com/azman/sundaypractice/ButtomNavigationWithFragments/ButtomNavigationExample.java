package com.azman.sundaypractice.ButtomNavigationWithFragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.azman.sundaypractice.R;
import com.azman.sundaypractice.tablayoutfile.TabHome;
import com.azman.sundaypractice.tablayoutfile.TabSetting;
import com.azman.sundaypractice.tablayoutfile.TabStore;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ButtomNavigationExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_navigation_example);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // set default
        setFragment(new TabHome());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.home) {
                    setFragment(new TabHome());

                } else if (id == R.id.store) {
                    setFragment(new TabStore());

                } else if (id == R.id.setting) {
                    setFragment(new TabSetting());

                }

                return true;
            }
        });


    }

    private void setFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.Frame_layout, fragment)
                .commit();
    }
}
