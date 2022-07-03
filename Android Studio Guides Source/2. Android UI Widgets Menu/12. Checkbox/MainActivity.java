import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxFacebook, checkBoxInstagram, checkBoxYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        checkBoxFacebook = findViewById(R.id.checkBox);
        checkBoxInstagram = findViewById(R.id.checkBox2);
        checkBoxYoutube = findViewById(R.id.checkBox3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxFacebook.isChecked() && !checkBoxInstagram.isChecked() && !checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media app is Facebook",
                            Toast.LENGTH_SHORT).show();

                } else if (!checkBoxFacebook.isChecked() && checkBoxInstagram.isChecked()
                        && !checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media app is Instagram",
                            Toast.LENGTH_SHORT).show();

                } else if (!checkBoxFacebook.isChecked() && !checkBoxInstagram.isChecked()
                        && checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media app is Youtube",
                            Toast.LENGTH_SHORT).show();

                } else if (checkBoxFacebook.isChecked() && checkBoxInstagram.isChecked()
                        && !checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media apps are Facebook & Instagram",
                            Toast.LENGTH_SHORT).show();

                } else if (!checkBoxFacebook.isChecked() && checkBoxInstagram.isChecked()
                        && checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media apps are Instagram & Youtube",
                            Toast.LENGTH_SHORT).show();

                } else if (checkBoxFacebook.isChecked() && !checkBoxInstagram.isChecked()
                        && checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Favorite Social media apps are Facebook & Youtube",
                            Toast.LENGTH_SHORT).show();

                } else if (checkBoxFacebook.isChecked() && checkBoxInstagram.isChecked()
                        && checkBoxYoutube.isChecked()) {
                    Toast.makeText(getApplicationContext(),
                            "Your Favorite Social media apps are Facebook & Instagram & Youtube", Toast.LENGTH_SHORT)
                            .show();

                }
            }
        });

    }

}