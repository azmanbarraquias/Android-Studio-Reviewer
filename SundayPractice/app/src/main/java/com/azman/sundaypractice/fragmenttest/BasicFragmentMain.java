package com.azman.sundaypractice.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.azman.sundaypractice.R;
import com.google.android.material.snackbar.Snackbar;


public class BasicFragmentMain extends AppCompatActivity {

    Button firstFragmentBtn;
    Button secondFragmentBtn;
    Button thirdFragmentBtn;
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_fragment_main);

        firstFragmentBtn = this.findViewById(R.id.fragmentBtn1);
        secondFragmentBtn = this.findViewById(R.id.fragmentBtn2);
        thirdFragmentBtn = this.findViewById(R.id.fragmentBtn3);
        mFrameLayout = this.findViewById(R.id.frameLayout);

        Fragment fragment1 = new fragment1();
        Fragment fragment2 = new fragment2();
        Fragment fragment3 = new fragment3();

       replaceFragment(fragment1);

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(fragment1);
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateSnackBar();
                replaceFragment(fragment2);
            }
        });

        thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(fragment3);
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    public void CreateSnackBar(){
        Snackbar.make(mFrameLayout, "test", Snackbar.LENGTH_LONG).setAction("some text", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BasicFragmentMain.this, "Snackbar close", Toast.LENGTH_SHORT).show();
                // auto close when clicked snackbar
            }
        }).show();
    }

    @Override
    public void onBackPressed(){}
}