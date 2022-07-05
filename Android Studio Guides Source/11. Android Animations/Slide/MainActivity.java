import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonSlideUp;
    private Button buttonSlideDown;
    private Button buttonSlideLeft;
    private Button buttonSlideRight;


    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSlideUp = findViewById(R.id.button);
        buttonSlideDown = findViewById(R.id.button2);
        buttonSlideLeft = findViewById(R.id.button3);
        buttonSlideRight = findViewById(R.id.button4);

        buttonSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                imageView.startAnimation(animation);
            }
        });

        buttonSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                imageView.startAnimation(animation);
            }
        });

        buttonSlideLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
                imageView.startAnimation(animation);
            }
        });

        buttonSlideRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
                imageView.startAnimation(animation);
            }
        });

    }
}