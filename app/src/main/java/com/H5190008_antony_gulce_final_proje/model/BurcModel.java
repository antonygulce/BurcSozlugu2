package com.H5190008_antony_gulce_final_proje.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BurcModel {
    @SerializedName("BurcAdi")
    @Expose
    private String burcAdi;
    @SerializedName("BurcTarihi")
    @Expose
    private String burcTarihi;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("GunlukYorum")
    @Expose
    private String gunlukYorum;
    @SerializedName("GunlukYorumUrl")
    @Expose
    private String gunlukYorumUrl;

    public String getBurcAdi() {
        return burcAdi;
    }

    public void setBurcAdi(String burcAdi) {
        this.burcAdi = burcAdi;
    }

    public String getBurcTarihi() {
        return burcTarihi;
    }

    public void setBurcTarihi(String burcTarihi) {
        this.burcTarihi = burcTarihi;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getGunlukYorum() {
        return gunlukYorum;
    }

    public void setGunlukYorum(String gunlukYorum) {
        this.gunlukYorum = gunlukYorum;
    }

    public String getGunlukYorumUrl() {
        return gunlukYorumUrl;
    }

    public void setGunlukYorumUrl(String gunlukYorumUrl) {
        this.gunlukYorumUrl = gunlukYorumUrl;
    }

}
