import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckedTextView checkedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkedTextView = findViewById(R.id.checkedTextView);

        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedTextView.toggle();
                if (checkedTextView.isChecked()) {

                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "UnChecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}