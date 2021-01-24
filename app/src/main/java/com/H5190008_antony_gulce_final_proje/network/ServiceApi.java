package com.H5190008_antony_gulce_final_proje.network;



import com.H5190008_antony_gulce_final_proje.model.BurcModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

//Json dan verileri çekiyoruz
public interface ServiceApi {

    //base url
    //
    @GET("BurcSozluguApi.json")
    Observable<List<BurcModel>> burclariGetir();
}
