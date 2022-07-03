
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private ProgressBar mCustomProgressBar;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBar);
        mCustomProgressBar = findViewById(R.id.CustomProgressBar);

        CountDownTimer count = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                progress++;

                mProgressBar.setProgress((int) progress * 100 / (5000 / 1000));
                mCustomProgressBar.setProgress((int) progress * 100 / (5000 / 1000));

                // Get the Drawable custom_progressbar
                Drawable draw = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_progressbar);
                // set the drawable as progress drawable
                mCustomProgressBar.setProgressDrawable(draw);

            }

            @Override
            public void onFinish() {

                Snackbar.make(findViewById(R.id.progressBar_layout), "Progress Finished", Snackbar.LENGTH_SHORT).show();

            }
        };
        count.start();

    }

}