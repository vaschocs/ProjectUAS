package com.example.projectuas.Model;

public class MMatkulActivity {


    private String kodeMatkul;
    private String namaMatkul;
    private String hariMatkul;
    private String sesiMatkul;
    private String jmlSKSMatkul;

    public MMatkulActivity(String kodeMatkul, String namaMatkul, String hariMatkul, String sesiMatkul, String jmlSKSMatkul) {

        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.hariMatkul = hariMatkul;
        this.sesiMatkul = sesiMatkul;
        this.jmlSKSMatkul = jmlSKSMatkul;
    }


    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getHariMatkul() {
        return hariMatkul;
    }

    public void setHariMatkul(String hariMatkul){ this.hariMatkul = hariMatkul;
    }

    public String getSesiMatkul() {
        return sesiMatkul;
    }

    public void setSesiMatkul(String sesiMatkul){
        this.sesiMatkul = sesiMatkul;
    }

    public String getJmlSKSMatkul() {return jmlSKSMatkul;}
    public void setJmlSKSMatkul(String jmlSKSMatkul){this.jmlSKSMatkul=jmlSKSMatkul;}
}
