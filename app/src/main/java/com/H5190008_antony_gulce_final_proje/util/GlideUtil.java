package com.H5190008_antony_gulce_final_proje.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.H5190008_antony_gulce_final_proje.R;

    //Url den resmi indirip imgview için gerekli ayarlamaları yapıyoruz
public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }


}
