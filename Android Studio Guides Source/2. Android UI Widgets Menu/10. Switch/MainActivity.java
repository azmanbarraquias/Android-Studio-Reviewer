
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        SwitchCompat switchCompat = findViewById(R.id.switchCompat);
        ImageView imageView = findViewById(R.id.imageView);

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()) {

                    textView.setText("Light On");
                    imageView.setImageResource(R.drawable.light_on);

                } else {
                    textView.setText("Light Off");
                    imageView.setImageResource(R.drawable.light_off);
                }
            }
        });

    }

}