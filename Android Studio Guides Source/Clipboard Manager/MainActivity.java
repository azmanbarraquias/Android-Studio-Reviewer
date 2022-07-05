import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonCopy = findViewById(R.id.button);
        Button buttonPaste = findViewById(R.id.button2);

        final EditText editText = findViewById(R.id.editText);


        buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", text);
                clipboard.setPrimaryClip(clip); // Set the ClipBoard's primary clip

                // Clear the editText 
                editText.getText().clear();

            }
        });

        buttonPaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String pasteData;


                if (!(clipboard.hasPrimaryClip())) {

                    // if clipboard  doesn't contain any data
                    Toast.makeText(MainActivity.this, "No Data to buttonPaste", Toast.LENGTH_SHORT).show();

                } else if (!(clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))) {

                    // Clipboard has data but it is not plain text
                    Toast.makeText(MainActivity.this, "Data is not a Plain text", Toast.LENGTH_SHORT).show();

                } else {

                    // Clipboard has plain text
                    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                    pasteData = item.getText().toString();

                    // setText the clipboard data
                    editText.setText(pasteData);
                }

            }
        });


    }


}