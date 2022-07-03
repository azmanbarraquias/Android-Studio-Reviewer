import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher mTextSwitcher;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSwitcher = findViewById(R.id.textSwitcher);
        Button previous = findViewById(R.id.button3);
        Button next = findViewById(R.id.button);

        final String[] text = {"Develop your First app", "Open  android studio", "Create new project ",
                "Setup empty activity", "Give project name and finish", "Set up AVD", "press Shift + F10",
                "Congrats ! You built your first app"};


        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                // create textView
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(24);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.parseColor("#000000"));

                Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.);
                textView.setTypeface(typeface);


                return textView;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position < text.length - 1) {
                    position += 1; //position = position + 1;
                    mTextSwitcher.setText(text[position]);
                }


            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position > 0) {
                    position -= 1; // position = position - 1;
                    mTextSwitcher.setText(text[position]);
                }


            }
        });

   }

}