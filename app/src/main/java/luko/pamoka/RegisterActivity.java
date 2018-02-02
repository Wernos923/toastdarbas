package luko.pamoka;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    Button register1;
    EditText username, password,Rpassword, email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register1 = (Button) findViewById(R.id.register1);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Rpassword = (EditText) findViewById(R.id.Rpassword);
        email = (EditText) findViewById(R.id.Email);

        register1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                final String Username = username.getText().toString();

                if (Username.length() == 0) {
                    username.requestFocus();
                    username.setError("FIELD CANNOT BE EMPTY");
                } else if (!Username.matches("[a-zA-Z ]+")) {
                    username.requestFocus();
                    username.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                final String Password = password.getText().toString();
                if (Password.length() == 0) {
                    password.requestFocus();
                    password.setError("FIELD CANNOT BE EMPTY");
                } else if (!Password.matches("^[A-Za-z0-9.-]{5,13}$")) {
                    password.requestFocus();
                    password.setError("PLEASE USE ONLY ALPHABETIC CHARACTERS AND NUMBERS");
                }
                final String Email = email.getText().toString();
                if (Email.length() == 0) {
                    email.requestFocus();
                    email.setError("FIELD CANNOT BE EMPTY");
                } else if (!Email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$")) {
                    email.requestFocus();
                    email.setError("PLEASE MAKE SURE YOUR EMAIL IS WRITTEN CORRECTLY");
                }
                final String password1 = password.getText().toString();
                if (!password.getText().toString().equals(Rpassword.getText().toString())) {
                    password.setError("YOUR PASSWORDS DON'T MATCH");
                } else {
                    Toast.makeText(RegisterActivity.this, "Validation Successful", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button btnRGoBack = (Button) findViewById(R.id.back);
        btnRGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}


