import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRotateClockWise = findViewById(R.id.button);
        Button buttonRotateAntiClockWise = findViewById(R.id.button2);

        imageView = findViewById(R.id.image);

        buttonRotateClockWise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
                imageView.startAnimation(animation);
            }
        });

        buttonRotateAntiClockWise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anti_clockwise);
                imageView.startAnimation(animation);
            }
        });
    }
}