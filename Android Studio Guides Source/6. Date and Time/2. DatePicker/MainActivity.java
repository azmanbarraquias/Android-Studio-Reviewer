 import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePickerCalendar;
    private DatePicker datePickerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerCalendar = findViewById(R.id.date_picker);
        datePickerSpinner = findViewById(R.id.date_picker2);

        Calendar calendar = Calendar.getInstance();
        datePickerCalendar.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        monthOfYear += 1;
                        String date = dayOfMonth + "/" + monthOfYear + "/" + year;

                        Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();

                    }
                });

        datePickerSpinner.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        monthOfYear += 1;
                        String date = dayOfMonth + "/" + monthOfYear + "/" + year;

                        Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();

                    }
                });

    }

} 