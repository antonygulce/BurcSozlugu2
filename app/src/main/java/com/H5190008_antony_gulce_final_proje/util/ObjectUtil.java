package com.H5190008_antony_gulce_final_proje.util;

import com.H5190008_antony_gulce_final_proje.model.BurcModel;
import com.google.gson.Gson;

    //Objeler le ilgili Json ayarlarını yapıyoruz
public class ObjectUtil {

        public  static String burcToJsonString(BurcModel BurcModel)
        {
            Gson gson = new Gson();
            return   gson.toJson(BurcModel);
        }

        public  static BurcModel jsonStringToBurc(String jsonString)
        {
            Gson gson = new Gson();
            return  gson.fromJson(jsonString,BurcModel.class);
        }


}
