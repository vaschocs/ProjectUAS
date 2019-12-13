package com.example.projectuas.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MMahasiswaActivity {
    @SerializedName("foto")
    @Expose
    private String AndroidImage;
    @SerializedName("nim")
    @Expose
    private String nimMhs;
    @SerializedName("nama")
    @Expose
    private String namaMhs;
    @SerializedName("id")
    @Expose
    private String idMhs;
    @SerializedName("gelar")
    @Expose
    private String gelarMhs;
    @SerializedName("email")
    @Expose
    private String emailMhs;
    @SerializedName("alamat")
    @Expose
    private String alamatMhs;

    public MMahasiswaActivity(String id, String androidImage, String nimMhs, String namaMhs, String gelarMhs, String emailMhs, String alamatMhs) {

        this.idMhs = id;
        this.namaMhs = namaMhs;
        this.nimMhs = nimMhs;
        this.alamatMhs = alamatMhs;
        this.emailMhs = emailMhs;
        AndroidImage  = androidImage;

    }

    public String getIdMhs() { return idMhs; }

    public void setIdMhs(String idMhs) { this.idMhs = idMhs; }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }
    public String getNimMhs() { return nimMhs; }

    public void setNimMhs(String nimMhs) {
        this.nimMhs = nimMhs;
    }
    public String getAlamatMhs() {
        return alamatMhs;
    }

    public void setAlamatMhs(String alamatMhs){
        this.alamatMhs = alamatMhs;
    }
    public String getEmailMhs() {
        return emailMhs;
    }

    public void setEmailMhs(String emailMhs){
        this.emailMhs = emailMhs;
    }


    public String getAndroidImage() { return AndroidImage; }

    public void setAndroidImage(String androidImage) { AndroidImage = androidImage; }











}
