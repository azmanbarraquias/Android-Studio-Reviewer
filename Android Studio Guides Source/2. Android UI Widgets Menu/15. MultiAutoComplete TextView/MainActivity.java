import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] text = { "Java ", "Kotlin", "Python", "Javascript", "C#", "C/C++", "Swift",
                "PHP", "Objective-C", "Ruby", "Html", "CSS", "SQL" };

        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, text);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

}