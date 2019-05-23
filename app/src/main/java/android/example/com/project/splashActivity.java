package android.example.com.project;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    private int DELAY_SPLASH=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivities( new Intent(splashActivity.this, MainActivity.class));
            }
        }, DELAY_SPLASH);
    }
}
