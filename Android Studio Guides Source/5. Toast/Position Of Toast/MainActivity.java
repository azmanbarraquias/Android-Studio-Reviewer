import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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

        Button button = findViewById(R.id.toast_positions);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "Simple Toast", Toast.LENGTH_SHORT);
                toast.show();

                Toast toast1 = Toast.makeText(getApplicationContext(), "TOP", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.TOP, 0, 0);
                toast1.show();

                Toast toast2 = Toast.makeText(getApplicationContext(), "RIGHT", Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.RIGHT, 0, 0);
                toast2.show();

                Toast toast3 = Toast.makeText(getApplicationContext(), "BOTTOM", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.BOTTOM, 0, 0);
                toast3.show();

                Toast toast4 = Toast.makeText(getApplicationContext(), "LEFT", Toast.LENGTH_SHORT);
                toast4.setGravity(Gravity.LEFT, 0, 0);
                toast4.show();

                Toast toast5 = Toast.makeText(getApplicationContext(), "TOP-LEFT", Toast.LENGTH_SHORT);
                toast5.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast5.show();

                Toast toast6 = Toast.makeText(getApplicationContext(), "TOP-RIGHT", Toast.LENGTH_SHORT);
                toast6.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
                toast6.show();

                Toast toast7 = Toast.makeText(getApplicationContext(), "BOTTOM-LEFT", Toast.LENGTH_SHORT);
                toast7.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                toast7.show();

                Toast toast8 = Toast.makeText(getApplicationContext(), "BOTTOM-RIGHT", Toast.LENGTH_SHORT);
                toast8.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
                toast8.show();

            }
        });
    }

}