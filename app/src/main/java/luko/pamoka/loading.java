package luko.pamoka;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class loading extends AppCompatActivity {
    ProgressBar progressBar1;
    int progress = 0;
    TextView textView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar1 = (ProgressBar) findViewById(R.id.progress1);
        textView = (TextView) findViewById(R.id.text1);


        new Thread(new Runnable() {

            @Override
            public void run() {
                while(progress<100){
                    progress +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar1.setProgress(progress);
                            textView.setText(progress + "/" + progressBar1.getMax());
                        }
                    });

                        try{
                            Thread.sleep(50);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }

                    }

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                }

            }).start();

    }
}
