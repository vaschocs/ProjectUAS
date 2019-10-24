package com.example.projectuas.Model;

public class MKRSActivity {

    private String kodeMatkulK;
    private String namaMatkulK;
    private String hariMatkulK;
    private String jmlSKSK;
    private String dsnPengampuK;
    private String JmlMHSK;


    public MKRSActivity(String kodeMatkulK, String namaMatkulK, String hariMatkulK, String jmlSKSK, String dsnPengampuK,String JmlMHSK) {

        this.kodeMatkulK = kodeMatkulK;
        this.namaMatkulK = namaMatkulK;
        this.hariMatkulK = hariMatkulK;
        this.jmlSKSK = jmlSKSK;
        this.dsnPengampuK = dsnPengampuK;
        this.JmlMHSK = JmlMHSK;
    }


    public String getKodeMatkulK() {
        return kodeMatkulK;
    }

    public void setKodeMatkulK(String kodeMatkulK) {
        this.kodeMatkulK = kodeMatkulK;
    }

    public String getNamaMatkulK() {
        return namaMatkulK;
    }

    public void setNamaMatkulK(String namaMatkulK) {
        this.namaMatkulK = namaMatkulK;
    }

    public String getHariMatkulK() {
        return hariMatkulK;
    }

    public void setHariMatkulK(String hariMatkulK){
        this.hariMatkulK = hariMatkulK;
    }

    public String getJmlSKSK() {
        return jmlSKSK;
    }

    public void setJmlSKSK(String alamatMhs){
        this.jmlSKSK = jmlSKSK;
    }

    public String getDsnPengampuK() {
        return dsnPengampuK;
    }

    public void setDsnPengampuK(String dsnPengampuK){
        this.dsnPengampuK = dsnPengampuK;
    }

    public String getJmlMHSK() {
        return JmlMHSK;
    }

    public void setJmlMHSK(String jmlMHSK){
        this.JmlMHSK = jmlMHSK;
    }

}
