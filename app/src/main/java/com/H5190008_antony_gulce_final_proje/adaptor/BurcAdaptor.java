package com.H5190008_antony_gulce_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.H5190008_antony_gulce_final_proje.model.BurcModel;
import com.H5190008_antony_gulce_final_proje.util.GlideUtil;
import com.H5190008_antony_gulce_final_proje.R;

import java.util.List;

public class BurcAdaptor extends RecyclerView.Adapter<BurcViewHolder> {


    List<BurcModel> burclar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }


    public BurcAdaptor(List<BurcModel> burclar, Context context,OnItemClickListener listener) {
        this.burclar = burclar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BurcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_burc,parent,false);
        return new BurcViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BurcViewHolder viewHolder, int position) {

        viewHolder.txtTarih.setText(burclar.get(position).getBurcTarihi());
        viewHolder.txtBurcAdi.setText(burclar.get(position).getBurcAdi());
        GlideUtil.resmiIndiripGoster(context,burclar.get(position).getLogoUrl(),viewHolder.imgBurcLogo);

    }

    @Override
    public int getItemCount() {
        return burclar.size();
    }
}
