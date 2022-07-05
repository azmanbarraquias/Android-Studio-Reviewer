import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonSchedule = findViewById(R.id.button);
        final Button buttonCancel = findViewById(R.id.button2);


        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To create popUp menu refer to Menu --> PopUp menu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonSchedule);
                popupMenu.getMenuInflater().inflate(R.menu.notification_menu, popupMenu.getMenu());


                // PopUp Menu click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.item_1:

                                // 5 seconds --> 5000 milli seconds
                                scheduleNotification(1, "5 Seconds", 5000);
                                Toast.makeText(getApplicationContext(), "Notification scheduled (5 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_2:

                                scheduleNotification(2, "10 Seconds", 10000);
                                Toast.makeText(getApplicationContext(), "Notification scheduled (10 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_3:

                                scheduleNotification(3, "15 Seconds", 15000);
                                Toast.makeText(getApplicationContext(), "Notification scheduled (15 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_4:

                                scheduleNotification(4, "30 Seconds", 30000);
                                Toast.makeText(getApplicationContext(), "Notification scheduled (30 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_5:

                                scheduleNotification(5, "60 Seconds", 60000);
                                Toast.makeText(getApplicationContext(), "Notification scheduled (60 seconds)", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                    }
                });
                popupMenu.show();

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To create popUp menu refer to Menu --> PopUp menu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonSchedule);
                popupMenu.getMenuInflater().inflate(R.menu.notification_menu, popupMenu.getMenu());


                // PopUp Menu click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.item_1:


                                cancelNotification(1, "5 Seconds");
                                Toast.makeText(getApplicationContext(), "Notification Cancelled (5 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_2:

                                cancelNotification(2, "10 Seconds");
                                Toast.makeText(getApplicationContext(), "Notification Cancelled (10 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_3:

                                cancelNotification(3, "15 Seconds");
                                Toast.makeText(getApplicationContext(), "Notification Cancelled (15 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_4:

                                cancelNotification(4, "30 Seconds");
                                Toast.makeText(getApplicationContext(), "Notification Cancelled (30 Seconds)", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item_5:

                                cancelNotification(5, "60 Seconds");
                                Toast.makeText(getApplicationContext(), "Notification Cancelled (60 Seconds)", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                    }
                });
                popupMenu.show();

            }
        });


    }


    private void scheduleNotification(int id, String name, long delay) {

        Intent notification = new Intent(this, NotificationReceiver.class);
        notification.putExtra("ID", id); // notification id
        notification.putExtra("Name", name); // notification name

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, id, notification, PendingIntent.FLAG_UPDATE_CURRENT);

        // time since the system was booted + delay
        //  time in milliseconds that the alarm should go off
        long futureInMills = SystemClock.elapsedRealtime() + delay;

        // Schedule Notification
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, futureInMills, pendingIntent);
    }

    private void cancelNotification(int id, String name) {

        Intent notification = new Intent(this, NotificationReceiver.class);
        notification.putExtra("ID", id); // notification id
        notification.putExtra("Name", name); // notification name

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, id, notification, PendingIntent.FLAG_UPDATE_CURRENT);


        // Cancel Notification
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }


}