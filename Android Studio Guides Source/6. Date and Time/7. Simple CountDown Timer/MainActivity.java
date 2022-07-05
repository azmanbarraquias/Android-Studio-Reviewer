import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart, buttonStop;
    private TextView textviewTimeOne;
    private TextView textViewTimeTwo;

    private CountDownTimer countDownTimerOne;
    private CountDownTimer countDownTimerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.start);
        buttonStop = findViewById(R.id.stop);

        buttonStop.setEnabled(false); // disable stop button before start countdown

        textviewTimeOne = findViewById(R.id.time1);
        textViewTimeTwo = findViewById(R.id.time2);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timerOne(); // call first  CountDownTimer Method
                timerTwo(); // call second CountDownTimer Method

                buttonStop.setEnabled(true);    // enable stop button after countdown start
                buttonStart.setEnabled(false); // disable start button after countdown start

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countDownTimerOne.cancel();
                countDownTimerTwo.cancel();

                buttonStop.setEnabled(false); // disable stop button after countdown stop
                start.setEnabled(true); // enable start button after countdown stop
            }
        });
    }

    public void timerOne() {

        // 1st parameter = millisInFuture --> 30000 ms = 30s
        // 2nd parameter = countDownInterval --> 1000 ms = 1s
        countDownTimerOne = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                textViewTimeOne.setText("00 : " + String.format("%02d", millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textviewTimeOne.setText("First CountDown Timer Finished !");
                textviewTimeOne.setTextColor(Color.parseColor("#63FF00"));

            }
        }.start();

    }

    public void timerTwo() {

        // 1st parameter = millisInFuture --> 120000 ms = 2 min
        // 2nd parameter = countDownInterval --> 1000 ms = 1s
        countDownTimerTwo = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60;


                textViewTimeTwo.setText(String.format("%02d : %02d", minutes, seconds));

            }

            @Override
            public void onFinish() {

                textViewTimeTwo.setText("Second CountDown Timer Finished !");
                textViewTimeTwo.setTextColor(Color.parseColor("#63FF00"));

            }
        }.start();

    }


}