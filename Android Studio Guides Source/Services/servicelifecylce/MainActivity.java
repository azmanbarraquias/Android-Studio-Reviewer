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

                Intent intent = new Intent(getApplicationContext(), ExampleService.class);
                if (state) {

                    // Start the service
                    startService(intent);
                    state = false;
                    button.setText("Stop Service");

                } else {

                    // stop the Service
                    stopService(intent);
                    state = true;
                    button.setText("Start Service");


                }

            }
        });

    }
}