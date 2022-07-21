import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private boolean state = true;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                if (state) {

                    // Start the service
                    startService(intent);
                    button.setText("Stop Service");
                    state = false;

                } else {

                    // stop the Service
                    stopService(intent);
                    button.setText("Start Service");
                    state = true;


                }

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        // Stop the Service when activity Paused , not service will  run in  until the Destroy
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        stopService(intent);
        state = true;
        button.setText("Start Service");

    }
}