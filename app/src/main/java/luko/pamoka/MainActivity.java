package luko.pamoka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {


    String cb1 = "";
    String name = "";
    String weight = "";
    String height = "";
    String rb = "";
    String rb1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText PokemonName = (EditText) findViewById(R.id.login_pokemon_name);
        final EditText PokemonWeight = (EditText) findViewById(R.id.Login_pokemon_weight);
        final EditText PokemonHeight = (EditText) findViewById(R.id.login_pokemon_height);
        final CheckBox cbVegan = (CheckBox) findViewById(R.id.Vegan);
        final CheckBox cbTwoHeads = (CheckBox) findViewById(R.id.twoHeads);
        final CheckBox cbFourLegs = (CheckBox) findViewById(R.id.FourLegs);
        final RadioButton rbStrong = (RadioButton) findViewById(R.id.login_pokemon_power_strong);
        final RadioButton rbNormal = (RadioButton) findViewById(R.id.login_pokemon_power_normal);
        final RadioButton rbWeak = (RadioButton) findViewById(R.id.login_pokemon_power_weak);
        final RadioButton rbAir = (RadioButton) findViewById(R.id.login_pokemon_class_air);
        final RadioButton rbWater = (RadioButton) findViewById(R.id.login_pokemon_class_water);
        final RadioButton rbEarth = (RadioButton) findViewById(R.id.login_pokemon_class_earth);

        Button btnAdd = (Button) findViewById(R.id.button_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                name = PokemonName.getText().toString();
                height = PokemonHeight.getText().toString();
                weight = PokemonWeight.getText().toString();

                if (cbVegan.isChecked()) {
                    cb1 = cb1 + " " + cbVegan.getText().toString();
                }if(cbTwoHeads.isChecked()){
                    cb1 = cb1 + " " +  cbTwoHeads.getText().toString();
                }if (cbFourLegs.isChecked()){
                    cb1 = cb1 + " " + cbFourLegs.getText().toString();
                }
              if(rbStrong.isChecked()){
                  rb = rb + " " + rbStrong.getText().toString();
              }else if(rbNormal.isChecked()){
                  rb = rb + " " + rbNormal.getText().toString();
              }else if(rbWeak.isChecked()){
                  rb = rb + " " + rbWeak.getText().toString();
              }
              if(rbAir.isChecked()){
                  rb1 = rb1 + " " + rbAir.getText().toString();
              }else if(rbEarth.isChecked()){
                  rb1 = rb1 + " " + rbEarth.getText().toString();
              }else if(rbWater.isChecked()){
                  rb1 = rb1 + " " + rbWater.getText().toString();
              }
              String messageForToast = "Name: " + name +  "\n" + "Type: " + cb1 + "\n"
                      + "Class: " + rb1 + "\n" + "Power: " + rb + "\n" + "Weight: " + weight + "\n" + "Height: " + height + "\n";

                Toast.makeText(MainActivity.this,
                        messageForToast.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}






