package com.example.keteringapp.ui.pesan;

public class getpesaqiqah {
    String pemdietId;
    String pemdietNama;
    String pemdietNohp;
    String pemdietAlamat;
    String pemdietSpinneraqiqah;
    String pemdietTanggal;

    public getpesaqiqah(){

    }

    public getpesaqiqah(String pemdietId, String pemdietNama, String pemdietNohp, String pemdietAlamat, String pemdietSpinneraqiqah, String pemdietTanggal) {
        this.pemdietId = pemdietId;
        this.pemdietNama = pemdietNama;
        this.pemdietNohp = pemdietNohp;
        this.pemdietAlamat = pemdietAlamat;
        this.pemdietSpinneraqiqah = pemdietSpinneraqiqah;
        this.pemdietTanggal = pemdietTanggal;
    }

    public String getPemdietId() {
        return pemdietId;
    }

    public String getPemdietNama() {
        return pemdietNama;
    }

    public String getPemdietNohp() {
        return pemdietNohp;
    }

    public String getPemdietAlamat() {
        return pemdietAlamat;
    }

    public String getPemdietSpinneraqiqah() {
        return pemdietSpinneraqiqah;
    }

    public String getPemdietTanggal() {
        return pemdietTanggal;
    }
}
