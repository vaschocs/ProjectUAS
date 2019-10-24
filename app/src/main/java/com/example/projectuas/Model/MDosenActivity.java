package com.example.projectuas.Model;

public class MDosenActivity {

    private int AndroidImage;
    private String nidnDsn;
    private String namaDsn;
    private String gelarDsn;
    private String emailDsn;
    private String alamatDsn;

    public MDosenActivity(int androidImage, String nidnDsn, String namaDsn, String gelarDsn, String emailDsn, String alamatDsn) {
        AndroidImage = androidImage;
        this.nidnDsn = nidnDsn;
        this.namaDsn = namaDsn;
        this.gelarDsn = gelarDsn;
        this.emailDsn = emailDsn;
        this.alamatDsn = alamatDsn;
    }

    public int getAndroidImage() {
        return AndroidImage;
    }

    public void setAndroidImage(int androidImage) {
        AndroidImage = androidImage;
    }

    public String getNidnDsn() {
        return nidnDsn;
    }

    public void setNidnDsn(String nidnDsn) {
        this.nidnDsn = nidnDsn;
    }

    public String getNamaDsn() {
        return namaDsn;
    }

    public void setNamaDsn(String namaDsn) {
        this.namaDsn = namaDsn;
    }

    public String getGelarDsn() {
        return gelarDsn;
    }

    public void setGelarDsn(String gelarDsn) {
        this.gelarDsn = gelarDsn;
    }



    public String getEmailDsn() {
        return emailDsn;
    }

    public void setEmailDsn(String emailDsn){
        this.emailDsn = emailDsn;
    }

    public String getAlamatDsn() {
        return alamatDsn;
    }

    public void setAlamatDsn(String alamatDsn){
        this.alamatDsn = alamatDsn;
    }

}
