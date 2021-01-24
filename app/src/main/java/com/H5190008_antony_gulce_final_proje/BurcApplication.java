package com.H5190008_antony_gulce_final_proje;

import android.app.Application;

    //Programın AppUtilini oluşturuyoruz
public class BurcApplication extends Application {
    BurcApplication app = null;

    public BurcApplication getApp() {
        if (app == null) {
            app = this;
        }
        return app;
    }
}