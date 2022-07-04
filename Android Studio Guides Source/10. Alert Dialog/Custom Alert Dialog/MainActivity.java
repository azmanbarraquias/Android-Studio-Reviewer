import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert_dialog);

        Button button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_alert_dialog);
                dialog.setCancelable(true); //  Sets whether the dialog is cancelable or not


                Button button = dialog.findViewById(R.id.button);
                Button button2 = dialog.findViewById(R.id.button2);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Replace your Action Here

                        dialog.cancel(); // Cancel the dialog

                        Toast.makeText(MainActivity.this, "You Clicked Cancel", Toast.LENGTH_SHORT).show();

                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Replace your Action Here

                        dialog.cancel(); // Cancel the dialog

                        Toast.makeText(MainActivity.this, "You Clicked OK", Toast.LENGTH_SHORT).show();

                    }
                });

                // Show the dialog
                dialog.show();

            }
        });

    }
}