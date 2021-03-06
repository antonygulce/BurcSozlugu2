package com.H5190008_antony_gulce_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;

import com.H5190008_antony_gulce_final_proje.R;

public class SplashActivity extends AppCompatActivity {
//çağırır
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(!isConnected(this)){
            showCustomDialog();
        }else {
            init();
        }


    }
    //Dialogu gösterir
    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setMessage(R.string.internet_alert_yazisi)
                .setCancelable(false)
                .setPositiveButton(R.string.baglan_diyalogu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity( new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton(R.string.kapat_diyalogu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        finish();
                    }

                });

        AlertDialog alert = builder.create();
        alert.show();

    }


//İnternet kontrolü

    private boolean isConnected(SplashActivity splashActivity) {

        ConnectivityManager connectivityManager = (ConnectivityManager) splashActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected())  || (mobileConn != null && mobileConn.isConnected()))  {
            return true;
        }
        else{
            return false;
        }


    }







// 3 soaniye sonra diğer ekrana geçer

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
// 3 soaniye sonra diğer ekrana geçer

    private void openNextActivity(){
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }


}