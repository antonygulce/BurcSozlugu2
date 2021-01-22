package com.H5190008_antony_gulce_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.H5190008_antony_gulce_final_proje.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();


    }
    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

                Log.e("COUNTER","TİCK");
            }

            @Override
            public void onFinish() {
               openNextActivity();

            }
        };

        countDownTimer.start();



    }







    private void openNextActivity(){
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }


}