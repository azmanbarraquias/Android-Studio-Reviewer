import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(Activity_PopupMenu.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());

                // PopUp Menu click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

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

                        return true;
                    }
                });
                popupMenu.show();

            }
        });
    }
}