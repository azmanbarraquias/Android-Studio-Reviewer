import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final long TIMER_DURATION = 120000;
    private static final long TIMER_INTERVAL = 1000;

    private Button buttonStart, buttonStop, buttonReset;

    private TextView textView;

    private CountDownTimer countDownTimer;

    private long timeRemaining;

    private boolean timerActive = false;
    private boolean timerStop = false;

    @Override
    protected void onResume() {
        super.onResume();


        try {
            if (timerActive) // Or  timerActive == true
            {
                if (countDownTimer == null && !timerStop) // timer is null   , recreate it with remaining time
                {

                    timer(timeRemaining, TIMER_INTERVAL); // Call CountDown Timer

                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (timerActive) {
            countDownTimer.cancel();
            countDownTimer = null;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.start);
        buttonStop = findViewById(R.id.stop);
        buttonReset = findViewById(R.id.reset);

        buttonStop.setEnabled(false); // disable stop button before start countdown
        buttonReset.setEnabled(false); // disable reset button before start countdown

        textView = findViewById(R.id.time1);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    timerActive = true;

                    if (!timerStop) // Timer not stopped yet. start it.
                    {
                        timer(TIMER_DURATION, TIMER_INTERVAL); // Call CountDown Timer
                    } else {

                        timer(timeRemaining, TIMER_INTERVAL); // Timer is stopped by the user , recreate it with remaining time

                    }

                    timerStop = false;

                    buttonStop.setEnabled(true); // enable stop button after countdown start
                    buttonReset.setEnabled(true); // enable reset button after countdown start
                    buttonStart.setEnabled(false); // disable start button after countdown start

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    countDownTimer.cancel();

                    TimerStop = true;

                    buttonStop.setEnabled(false); // disable stop button after countdown stop
                    buttonReset.setEnabled(false); // disable reset button after countdown stop
                    buttonStart.setEnabled(true); // enable start button after countdown stop

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    countDownTimer.cancel();
                    textView.setText("02 : 00");
                    textView.setTextColor(Color.parseColor("#FF4A4A"));

                    buttonStop.setEnabled(false); // disable stop button after countdown reset
                    buttonReset.setEnabled(false); // disable reset button after countdown reset
                    buttonStart.setEnabled(true); // enable start button after reset

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }

    public void timer(long millisInFuture, long countDownInterval) {


        countDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeRemaining = millisUntilFinished;

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60;


                textView.setText(String.format("%02d : %02d", minutes, seconds));

            }

            @Override
            public void onFinish() {

                textView.setText("CountDown Timer Finished !");
                textView.setTextColor(Color.parseColor("#63FF00"));


            }
        }.start();

    }


}   