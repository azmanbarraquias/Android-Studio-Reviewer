package com.azman.sundaypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class ButtomSheets extends AppCompatActivity
{
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private View bottomSheet;

    private Button button;
    private boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_sheets);
        bottomSheet = findViewById(R.id.design_bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        button = findViewById(R.id.button);

        state = true;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    state = false;
                    button.setText("Collapse ButtonSheet");

                } else {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    state = true;
                    button.setText("Expand ButtonSheet");
                }


            }
        });


    }
}