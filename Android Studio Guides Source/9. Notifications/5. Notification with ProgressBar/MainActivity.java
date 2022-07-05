import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "Notification";
    private final int NOTIFICATION_ID = 01;
    private Button button;
    private NotificationCompat.Builder builder;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notificationManager = NotificationManagerCompat.from(getApplicationContext());

                createNotificationChannel();

                builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle("File Download")
                        .setContentText("Download in progress")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {

                                int PROGRESS_MAX = 100;
                                int PROGRESS;

                                for (PROGRESS = 0; PROGRESS <= 100; PROGRESS += 10) {

                                    //show the progress bar
                                    builder.setProgress(PROGRESS_MAX, PROGRESS, false);
                                    notificationManager.notify(NOTIFICATION_ID, builder.build());

                                    try {
                                        // sleep for 3 seconds
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                //When done,update the notification one more time to remove the progress bar
                                builder.setContentText("Download Complete")
                                        .setProgress(0, 0, false);
                                notificationManager.notify(NOTIFICATION_ID, builder.build());
                            }
                        }
                ).start();


            }
        });
    }

    //create notification channel for android 8.0 or higher to deliver notification
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Notification";
            String description = "Notification with ProgressBar";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}