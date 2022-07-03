import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.ViewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        // Return Fragment to display for that page
        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new TabHome();
                case 1:
                    return new TabStore();
                case 2:
                    return new TabSetting();
                default:
                    return null;
            }
        }

        // will be displayed as the tab's label
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "HOME";
                case 1:
                    return "STORE";
                case 2:
                    return "SETTING";
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}