package com.H5190008_antony_gulce_final_proje.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.H5190008_antony_gulce_final_proje.R;


public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
