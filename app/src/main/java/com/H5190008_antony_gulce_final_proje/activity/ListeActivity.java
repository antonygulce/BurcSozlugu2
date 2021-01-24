package com.H5190008_antony_gulce_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.H5190008_antony_gulce_final_proje.adaptor.BurcAdaptor;
import com.H5190008_antony_gulce_final_proje.model.BurcModel;
import com.H5190008_antony_gulce_final_proje.network.Service;
import com.H5190008_antony_gulce_final_proje.util.Constants;
import com.H5190008_antony_gulce_final_proje.util.ObjectUtil;


import com.H5190008_antony_gulce_final_proje.R;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //voidi çağırır
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }

    private  void  init()
    {

        burclariGetir();
    }


//Versionları Al
    void  burclariGetir()
    {

        new Service().getServiceApi().burclariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BurcModel>>() {

                    List<BurcModel> burclar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }


                    @Override
                    public void onNext(List<BurcModel> burcList) {
                        Log.e("RETROFIT","onNext : ");
                        burclar=burcList;
                    }
                    //Hata gelirse log at
                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }
                    //bittiğini söyler
                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(burclar.size()>0) {

                            initRecycleView(burclar);
                        }
                    }
                });
    }

    //Veriler gelene akdar bekleme
    private  void  initRecycleView(List<BurcModel> burcList)
    {
        recyclerView =findViewById(R.id.rcvBurclar);
        BurcAdaptor burcAdaptor =new BurcAdaptor(burcList, getApplicationContext(), new BurcAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                BurcModel tiklananBurc = burcList.get(position);
                Toast.makeText(getApplicationContext(),R.string.tiklanan_burc_adi + tiklananBurc.getBurcAdi(), Toast.LENGTH_SHORT).show();


                openNextActivity(tiklananBurc);

            }
        });

// Datasını ayarlama
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(burcAdaptor);
    }

//Diğer ekrana geçme
    private void openNextActivity(BurcModel tiklananBurc){

        Intent secondActivityIntent=new Intent(getApplicationContext(), BurcDetayActivity.class);
        String tiklananBurcString = ObjectUtil.burcToJsonString(tiklananBurc);

        secondActivityIntent.putExtra(Constants.TIKLANAN_BURC_TASINANIN_BASLIGI,tiklananBurcString);
        startActivity(secondActivityIntent);



    }

}