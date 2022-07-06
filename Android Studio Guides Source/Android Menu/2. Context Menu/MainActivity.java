import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        //Registers a context menu to be shown for the given view
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Set title
        menu.setHeaderTitle("Select the option");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


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

        return super.onContextItemSelected(item);
    }
}