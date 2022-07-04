import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Simple Alert Dialog"); // set Title
                builder.setMessage("Do you need to back to Menu");  // set message
                builder.setCancelable(true); //  Sets whether the dialog is cancelable or not
                builder.setIcon(R.mipmap.app_icon_foreground);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Replace your Own Action

                        // Cancel the AlertDialog
                        alertDialog.cancel();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Replace your Own Action

                                // Cancel the AlertDialog
                                alertDialog.cancel();

                            }
                        });


                alertDialog = builder.create();
                alertDialog.show();


            }
        });

    }
}