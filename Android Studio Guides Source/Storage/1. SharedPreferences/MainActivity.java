import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean booleanValue;
    int intValue;
    String stringValue;


    // Default string Value
    String defaultString = "No Data";
    
    // Default int Value
    int intDefault = 0;
    
    // Default boolean value
    boolean booleanDefault = false;
    
    private EditText editText;
    private EditText editText1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextMultiLine);
        editText1 = findViewById(R.id.editTextNumberSigned);


        Button buttonSave = findViewById(R.id.button);
        Button buttonRead = findViewById(R.id.button2);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringValue = editText.getText().toString();
                String val = editText1.getText().toString().trim();

                if (!val.equals("")) {

                    intValue = Integer.parseInt(val);

                    // get boolean value
                    booleanValue = intValue >= 5;

                    // Call to the method
                    saveData();
                } else {

                    Toast.makeText(MainActivity.this, "Cannot Submit Empty Field", Toast.LENGTH_SHORT).show();
                }


            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Call to the method
                readData();
            }
        });


    }

    private void saveData() {

        
        SharedPreferences sharedPreferences = getSharedPreferences("Example", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Text", StringValue); // Save String Data
        editor.putInt("Number", intValue);   // Save int Data
        editor.putBoolean("State", booleanValue); // Save boolean Data
        editor.apply();


        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

    }

    private void readData() {

        SharedPreferences sharedPreferences = getSharedPreferences("Example", Context.MODE_PRIVATE);
        String text = sharedPreferences.getString("Text", defaultString);     // read saved String data
        int number = sharedPreferences.getInt("Number", intDefault);       // read saved int data
        boolean value = sharedPreferences.getBoolean("State", booleanDefault); // read saved boolean data


        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_SharedPreferences.this);
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.app_icon_foreground);
        builder.setTitle("Saved data");
        builder.setMessage("String Value :- " + text + "\n" +
                "int value :- " + number + "\n" +
                "boolean value :- " + value);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}