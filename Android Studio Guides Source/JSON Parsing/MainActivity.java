import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    private ArrayAdapter<String> adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);

        Button button = findViewById(R.id.button);

        adapter = new ArrayAdapter<>(this, R.layout.list_itemss);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call the method
                jsonParse();

            }
        });
    }

    public void jsonParse() {


        try {

            // load jsonObject
            JSONObject object = new JSONObject(loadJson());

            // The value mapped by name if it exists and is a JSONArray
            JSONArray array = object.getJSONArray("data");

            for (int i = 0; i < array.length(); i++) {

                JSONObject data = array.getJSONObject(i);

                int id = data.getInt("Id");
                String name = data.getString("Name");
                String email = data.getString("Email");

                adapter.add("ID :- " + id + "\n" +
                        "Name :- " + name + "\n" +
                        "Email :- " + email);

            }

            listView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // load json file from the assets folder
    public String loadJson() {

        String json = null;
        try {
            InputStream stream = getAssets().open("example.json"); // fileName
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }


}