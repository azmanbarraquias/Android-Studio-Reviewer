import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {


    private final String fileName = "example.txt";
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

                String text = editText.getText().toString();

                try {

                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(text.getBytes());

                    Toast.makeText(Activity_Internal.this, "Data Saved Successfully in" + getFilesDir() + "/" + fileName, Toast.LENGTH_LONG).show();

                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    FileInputStream inputStream = openFileInput(fileName);
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
                    builder.setTitle("stringBuilder.toString()");
                    builder.setMessage(Text);

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
}