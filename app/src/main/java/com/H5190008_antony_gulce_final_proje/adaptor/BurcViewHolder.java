package com.H5190008_antony_gulce_final_proje.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.H5190008_antony_gulce_final_proje.R;

public class BurcViewHolder extends RecyclerView.ViewHolder {

    ImageView imgBurcLogo;
    TextView txtBurcAdi;
    TextView txtTarih;

    //Mouse a tıklandığında verileri getirir
    public BurcViewHolder(@NonNull View cardView,BurcAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgBurcLogo =cardView.findViewById(R.id.imageBurcLogo);
        txtBurcAdi =cardView.findViewById(R.id.txtBurcAdi);
        txtTarih =cardView.findViewById(R.id.txtTarih);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClick(getAdapterPosition());
            }
        });
    }
}
