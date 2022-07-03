import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);

        String[] colors = { "Blue", "Green", "Yellow", "Orange", "Purple" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, colors);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        constraintLayout.setBackgroundColor(Color.parseColor("#0091EA"));
                        break;
                    case 1:
                        constraintLayout.setBackgroundColor(Color.parseColor("#5CF89D"));
                        break;
                    case 2:
                        constraintLayout.setBackgroundColor(Color.parseColor("#FFEC87"));
                        break;
                    case 3:
                        constraintLayout.setBackgroundColor(Color.parseColor("#F9A86C"));
                        break;
                    case 4:
                        constraintLayout.setBackgroundColor(Color.parseColor("#C39AFC"));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}