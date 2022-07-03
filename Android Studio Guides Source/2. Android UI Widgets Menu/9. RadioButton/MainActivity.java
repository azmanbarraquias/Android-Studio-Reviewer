import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radio_group);

        RadioButton radioButtonBlue = findViewById(R.id.radioButton);
        RadioButton radioButtonGreen = findViewById(R.id.radioButton2);
        RadioButton radioButtonRed = findViewById(R.id.radioButton3);

        ConstraintLayout constraintLayout = findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton:
                        constraintLayout.setBackgroundColor(Color.parseColor("#FF87CFFB"));
                        break;
                    case R.id.radioButton2:
                        constraintLayout.setBackgroundColor(Color.parseColor("#FF6EFEAA"));
                        break;
                    case R.id.radioButton3:
                        constraintLayout.setBackgroundColor(Color.parseColor("#FEACBC"));
                }
            }
        });

    }

}