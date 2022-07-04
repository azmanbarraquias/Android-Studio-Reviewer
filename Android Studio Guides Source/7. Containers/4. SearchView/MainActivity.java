import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        SearchView searchView = findViewById(R.id.searchView);

        final String[] texts = {"Java", "Kotlin ", "Python", "JavaScript",
                "C#", "C/C++", "Swift", "PHP",
                "Objective-C", "Ruby",
                "Html", "CSS", "SQL"};

       adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, texts);

        // set adapter
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(this);

        // ListView Item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // get Item name of clicked position
                String itemName = (String) parent.getItemAtPosition(position);

                switch (itemName) {
                    case "Java":
                        Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_SHORT).show();
                        break;
                    case "Kotlin":
                        Toast.makeText(getApplicationContext(), "Kotlin", Toast.LENGTH_SHORT).show();
                        break;
                    case "Python":
                        Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_SHORT).show();
                        break;
                    case "JavaScript":
                        Toast.makeText(getApplicationContext(), "JavaScript", Toast.LENGTH_SHORT).show();
                        break;
                    case "C#":
                        Toast.makeText(getApplicationContext(), "C#", Toast.LENGTH_SHORT).show();
                        break;
                    case "C/C++":
                        Toast.makeText(getApplicationContext(), "C/C++", Toast.LENGTH_SHORT).show();
                        break;
                    case "Swift":
                        Toast.makeText(getApplicationContext(), "Swift", Toast.LENGTH_SHORT).show();
                        break;
                    case "PHP":
                        Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_SHORT).show();
                        break;
                    case "Objective-C":
                        Toast.makeText(getApplicationContext(), "Objective-C", Toast.LENGTH_SHORT).show();
                        break;
                    case "Ruby":
                        Toast.makeText(getApplicationContext(), "Ruby", Toast.LENGTH_SHORT).show();
                        break;
                    case "Html":
                        Toast.makeText(getApplicationContext(), "Html", Toast.LENGTH_SHORT).show();
                        break;
                    case "CSS":
                        Toast.makeText(getApplicationContext(), "CSS", Toast.LENGTH_SHORT).show();
                        break;
                    case "SQL":
                        Toast.makeText(getApplicationContext(), "SQL", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        adapter.getFilter().filter(newText);
        return false;
    }
}  