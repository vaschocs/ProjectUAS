package com.example.projectuas.Model;

public class MMahasiswaActivity {

    private int AndroidImage;
    private String nimMhs;
    private String namaMhs;
    private String emailMhs;
    private String alamatMhs;

    public MMahasiswaActivity(int androidImage, String nimMhs, String namaMhs, String emailMhs, String alamatMhs) {
        AndroidImage = androidImage;
        this.nimMhs = nimMhs;
        this.namaMhs = namaMhs;
        this.emailMhs = emailMhs;
        this.alamatMhs = alamatMhs;
    }

    public int getAndroidImage() {
        return AndroidImage;
    }

    public void setAndroidImage(int androidImage) {
        AndroidImage = androidImage;
    }

    public String getNimMhs() {
        return nimMhs;
    }

    public void setNimMhs(String nimMhs) {
        this.nimMhs = nimMhs;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getEmailMhs() {
        return emailMhs;
    }

    public void setEmailMhs(String emailMhs){
        this.emailMhs = emailMhs;
    }

    public String getAlamatMhs() {
        return alamatMhs;
    }

    public void setAlamatMhs(String alamatMhs){
        this.alamatMhs = alamatMhs;
    }

}
