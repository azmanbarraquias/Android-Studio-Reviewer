
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {

                    Toast.makeText(getApplicationContext(), "Toggle button checked", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Toggle button unchecked", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}