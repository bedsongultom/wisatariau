package com.bedsongultom.wisatariau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SplashScreen extends AppCompatActivity implements Runnable{

    TextView tvcopyright;
    String copyright = "Copyright \u00a9 2017-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tvcopyright = (TextView) findViewById(R.id.tvcopyright);
        String currentDate = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());
        tvcopyright.setText(copyright+ currentDate +" Wisata Riau");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        new Handler().postDelayed(this, 5000);

    }

    @Override
    public void run() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}