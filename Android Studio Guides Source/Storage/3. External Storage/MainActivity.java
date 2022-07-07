import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends AppCompatActivity {


    private final String fileName = "example.txt";
    String text;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);

        Button buttonSave = findViewById(R.id.button);
        Button buttonRead = findViewById(R.id.button2);

        buttonSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                text = editText.getText().toString();

                // check permission
                if (ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {

                    // permission granted
                    // continue the action
                    saveData();


                } else {
                    // permission not granted
                    // ask for the permission
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE}, 1);

                }
            }
        });


        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    File file = new File(Environment.getExternalStorageDirectory(), fileName);

                    FileInputStream inputStream = new FileInputStream(file);
                    InputStreamReader streamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(streamReader);

                    StringBuilder stringBuilder = new StringBuilder();

                    String Text;

                    while ((Text = bufferedReader.readLine()) != null) {
                        stringBuilder.append(Text);
                    }

                    inputStream.close();


                    // show the data
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setIcon(R.mipmap.app_icon_foreground);
                    builder.setTitle("Saved data");
                    builder.setMessage(stringBuilder.toString());

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {

                    // permission granted
                    // Continue the action
                    saveData();

                } else {
                    // permission denied
                    Toast.makeText(this, "You cannot save file without permission", Toast.LENGTH_SHORT).show();
                }
        }
        return;
    }

    private void saveData() {

        try {

            File file = new File(Environment.getExternalStorageDirectory(), fileName);

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(text.getBytes());

            Toast.makeText(MainActivity.this, "Data Saved Successfully in" + getFilesDir() + "/" + fileName, Toast.LENGTH_LONG).show();

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}