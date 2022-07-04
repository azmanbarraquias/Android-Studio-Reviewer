import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_View);

        final String[] text = {"Java", "Kotlin ", "Python", "Javascript",
                "C#", "C/C++", "Swift", "PHP",
                "Objective-C", "Ruby",
                "Html", "CSS"};

        mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, text);

        // set Adapter to GridView
        gridView.setAdapter(mAdapter);

        // Click listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Kotlin", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "JavaScript", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "C#", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "C/C++", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(), "Swift", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(), "Objective-C", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(getApplicationContext(), "Ruby", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(getApplicationContext(), "Html", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(getApplicationContext(), "CSS", Toast.LENGTH_SHORT).show();

                        /*
                         * OR
                         *
                         * YOU CAN TRY THIS
                         *
                         * Toast.makeText(getApplicationContext(),text[position], Toast.LENGTH_SHORT).show();
                         *
                         * */


                }
            }
        });

    }
}