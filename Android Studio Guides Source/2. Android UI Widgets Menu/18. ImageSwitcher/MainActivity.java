import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSwitcher = findViewById(R.id.imageSwitcher);
        Button buttonPrevious = findViewById(R.id.button3);
        Button buttonNext = findViewById(R.id.button);

        int[] images = { R.drawable.image_one, R.drawable.image_two, R.drawable.image_three,
                R.drawable.image_four, R.drawable.image_five };

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position < images.length - 1) {
                    position += 1; // position = position + 1;
                    mImageSwitcher.setImageResource(images[position]);
                }

            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position > 0) {
                    position -= 1; // position = position - 1;
                    mImageSwitcher.setImageResource(images[position]);
                }

            }
        });

    }

}