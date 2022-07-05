import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);

        // Get instance of Vibrator from current Context
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator.hasVibrator()) {

            // Your device has Vibrator , Then You can Vibrate
            Toast.makeText(this, "You can Vibrate your Device", Toast.LENGTH_SHORT).show();
        } else {
            // Your device hasn't Vibrator
            Toast.makeText(this, "You cannot Vibrate your Device", Toast.LENGTH_SHORT).show();
            button.setEnabled(false);
            button1.setEnabled(false);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get instance of Vibrator from current Context
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                // Vibrate for 500 milliseconds --> 0.5 seconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    // According to docs A VibrationEffect describes a haptic effect to be performed by a Vibrator
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    v.vibrate(500);
                }


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get instance of Vibrator from current Context
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                // Start vibrate without delay
                // Vibrate foe 200 milliseconds
                // sleep for 300 milliseconds
                // vibrate , sleep , vibrate , sleep ..
                long[] pattern = {0, 200, 300, 200, 300, 200, 300};

                // 2nd parameter --> According to docs the index into pattern at which to repeat, or -1 if you don't want to repeat
                // If you use 0 instead of -1 , it will vibrate  indefinitely
                // Then just call the v.cancel(); to cancel vibrate
                v.vibrate(pattern, -1);

            }
        });

    }


}