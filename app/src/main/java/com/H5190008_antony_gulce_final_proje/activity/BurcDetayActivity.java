package com.H5190008_antony_gulce_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.H5190008_antony_gulce_final_proje.model.BurcModel;
import com.H5190008_antony_gulce_final_proje.util.Constants;
import com.H5190008_antony_gulce_final_proje.util.GlideUtil;
import com.H5190008_antony_gulce_final_proje.util.ObjectUtil;
import com.H5190008_antony_gulce_final_proje.R;

public class BurcDetayActivity extends AppCompatActivity {



    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    WebView webViewGunluk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burc_detay);
        init();

    }


    private void init (){
        String tasinanBurcString= getIntent().getStringExtra(Constants.TIKANAN_BURC_TASINANIN_BASLIGI);
        BurcModel burcModel = ObjectUtil.jsonStringToBurc(tasinanBurcString);

        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);
        webViewGunluk = findViewById(R.id.webViewGunluk);

        txtBaslik.setText(burcModel.getBurcAdi());
        txtDetay.setText(burcModel.getAciklama());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),burcModel.getKapakFotoUrl(),imgKapak);

        webViewGunluk.loadUrl(burcModel.getGunlukYorumUrl());

    }
}