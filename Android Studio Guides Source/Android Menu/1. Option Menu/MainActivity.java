import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(getApplicationContext(), "Item 1 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_2:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_3:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}