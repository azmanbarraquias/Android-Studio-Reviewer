import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditText;
    private TextInputEditText textInputEditTextPassword;

    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        textInputEditText = findViewById(R.id.Email);
        textInputEditTextPassword = findViewById(R.id.Password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // call the method when user submit details
                    login();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void login() {

        // get the input from user and remove all whitespaces
        String email = textInputEditText.getText().toString().trim();
        String password = textInputEditTextPassword.getText().toString().trim();

        if (email.isEmpty() || !validateEmail(email)) {
            if (email.isEmpty()) {

                // set error if field is empty
                textInputEditText.setError("Field Cannot be Empty");
            } else if (!validateEmail(email)) {

                // set error if email not valid
                textInputEditText.setError("Email is not valid");
            }
        }
        if (password.isEmpty() || !validatePassword(password) || password.length() < 6) {
            if (password.isEmpty()) {

                // set error if fields are empty
                textInputEditTextPassword.setError("Field Cannot be Empty");

            } else if (!validatePassword(password) || password.length() < 6) {

                // set error if password week
                textInputEditTextPassword.setError("Password is week");
            }
        } else {

            // set own action here
            Toast.makeText(this, "You are successfully logged In ", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateEmail(String email) {

        final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        return matcher.matches();

    }

    public boolean validatePassword(String password) {

        // This is how password pattern works

        // start of string --> ^
        // password must contain at least one digit --> 0-9 --> (?=.*[0-9])
        // password must contain at least one lover case letter --> a-z --> (?=.*[a-z])
        // password must contain at least one upper case letter --> A-Z --> (?=.*[A-Z])
        // no whitespace allowed in password --> (?=\S+$)
        // password must contain at least 6 characters and maximum of 20 characters -->
        // .{6,20}
        // end of string -- > $

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}