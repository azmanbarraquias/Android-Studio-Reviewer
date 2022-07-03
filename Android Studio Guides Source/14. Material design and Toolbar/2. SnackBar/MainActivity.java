import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.button);
        Button buttonTwo = findViewById(R.id.button2);

        constraintLayout = findViewById(R.id.main_layout);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Example Snackbar
                Snackbar.make(constraintLayout, "This is SnackBar", Snackbar.LENGTH_SHORT).show();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SnackBar with Action

                constraintLayout.setBackgroundColor(Color.parseColor("#C8F7FE"));

                Snackbar snackbar = Snackbar
                        .make(constraintLayout, " Background colour changed", Snackbar.LENGTH_INDEFINITE)
                        .setAction(" UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                // set Action
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            }
                        })
                        // set Action color
                        .setActionTextColor(Color.parseColor("#DD2C00"))
                        // set text color
                        .setTextColor(Color.parseColor("#FFFFFF"));

                snackbar.show();
            }
        });

    }
}