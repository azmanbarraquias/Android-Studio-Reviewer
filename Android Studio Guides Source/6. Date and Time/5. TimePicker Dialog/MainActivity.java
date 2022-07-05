 import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePickerClock timePickerClock = findViewById(R.id.time_picker);
        TimePickerSpinner timePickerSpinner = findViewById(R.id.time_picker2);

        timePickerClock.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Snackbar.make(findViewById(R.id.timePicker), hourOfDay + ":" + minute, Snackbar.LENGTH_SHORT).show();
            }
        });

        timePickerSpinner.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Snackbar.make(findViewById(R.id.timePicker), hourOfDay + ":" + minute, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

} 