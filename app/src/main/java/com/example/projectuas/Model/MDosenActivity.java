package com.example.projectuas.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MDosenActivity {
    @SerializedName("foto")
    @Expose
    private String AndroidImage;
    @SerializedName("nidn")
    @Expose
    private String nidnDsn;
    @SerializedName("nama")
    @Expose
    private String namaDsn;
    @SerializedName("id")
    @Expose
    private String idDsn;
    @SerializedName("gelar")
    @Expose
    private String gelarDsn;
    @SerializedName("email")
    @Expose
    private String emailDsn;
    @SerializedName("alamat")
    @Expose
    private String alamatDsn;

    public MDosenActivity(String id, String androidImage, String nidnDsn, String namaDsn, String gelarDsn, String emailDsn, String alamatDsn) {

        this.idDsn = id;
        this.namaDsn = namaDsn;
        this.nidnDsn = nidnDsn;
        this.alamatDsn = alamatDsn;
        this.emailDsn = emailDsn;
        this.gelarDsn = gelarDsn;
        AndroidImage  = androidImage;

    }

    public String getIdDsn() { return idDsn; }

    public void setIdDsn(String idDsn) { this.idDsn = idDsn; }

    public String getNamaDsn() {
        return namaDsn;
    }

    public void setNamaDsn(String namaDsn) {
        this.namaDsn = namaDsn;
    }
    public String getNidnDsn() { return nidnDsn; }

    public void setNidnDsn(String nidnDsn) {
        this.nidnDsn = nidnDsn;
    }
    public String getAlamatDsn() {
        return alamatDsn;
    }

    public void setAlamatDsn(String alamatDsn){
        this.alamatDsn = alamatDsn;
    }
    public String getEmailDsn() {
        return emailDsn;
    }

    public void setEmailDsn(String emailDsn){
        this.emailDsn = emailDsn;
    }
    public String getGelarDsn() {
        return gelarDsn;
    }

    public void setGelarDsn(String gelarDsn) {
        this.gelarDsn = gelarDsn;
    }

    public String getAndroidImage() { return AndroidImage; }

    public void setAndroidImage(String androidImage) { AndroidImage = androidImage; }











}
