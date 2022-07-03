import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShort = findViewById(R.id.short_toast);
        Button buttonLong = findViewById(R.id.long_toast);

        buttonShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "This is a Short Toast", Toast.LENGTH_SHORT).show();
            }
        });

        buttonLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "This is a Long Toast", Toast.LENGTH_LONG).show();

            }
        });
    }

} 