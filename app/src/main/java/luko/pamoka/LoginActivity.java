package luko.pamoka;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {


    Button register,login;
    EditText username, password;
    Boolean saveLogin;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.Password);

        login.setOnClickListener(new View.OnClickListener() {

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
                else {

                    Button button1;
                    button1 = (Button) findViewById(R.id.login);
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(LoginActivity.this, "Validation Successful", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                Button button = (Button) findViewById(R.id.register);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(i);
                    }
                });


                    login = (Button)findViewById(R.id.login);
                    login.setOnClickListener(this);
                    username = (EditText)findViewById(R.id.username);
                    password = (EditText)findViewById(R.id.Password);
                    saveLogin = (CheckBox)findViewById(R.id.rememberMe);
                    loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                    loginPrefsEditor = loginPreferences.edit();

                    saveLogin = loginPreferences.getBoolean("saveLogin", false);
                    if (saveLogin == true) {
                       username.setText(loginPreferences.getString("username", ""));
                       password.setText(loginPreferences.getString("password", ""));
                        saveLogin.setChecked(true);
                    }
                }

                public void onClick(View view) {
                    if (view == login) {
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(username.getWindowToken(), 0);

                       username.getText().toString();
                       password.getText().toString();

                        if (saveLogin.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username","");
                            loginPrefsEditor.putString("password", "");
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }


                    }
                }

            }
        });
    }
}



