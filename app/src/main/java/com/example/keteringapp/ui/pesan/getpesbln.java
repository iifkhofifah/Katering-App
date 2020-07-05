package com.example.keteringapp.ui.pesan;

public class getpesbln {

    String pemblnId;
    String pemblnNama;
    String pemblnNohp;
    String pemblnAlamat;
    String pemblnSpinner;
    String pemblnTanggal;
    String pemblnPorsi;

    public getpesbln(){

    }

    public getpesbln(String pemblnId, String pemblnNama, String pemblnNohp, String pemblnAlamat, String pemblnSpinner, String pemblnTanggal, String pemblnPorsi) {
        this.pemblnId = pemblnId;
        this.pemblnNama = pemblnNama;
        this.pemblnNohp = pemblnNohp;
        this.pemblnAlamat = pemblnAlamat;
        this.pemblnSpinner = pemblnSpinner;
        this.pemblnTanggal = pemblnTanggal;
        this.pemblnPorsi = pemblnPorsi;
    }

    public String getPemblnId() {
        return pemblnId;
    }

    public String getPemblnNama() {
        return pemblnNama;
    }

    public String getPemblnNohp() {
        return pemblnNohp;
    }

    public String getPemblnAlamat() {
        return pemblnAlamat;
    }

    public String getPemblnSpinner() {
        return pemblnSpinner;
    }

    public String getPemblnTanggal() {
        return pemblnTanggal;
    }

    public String getPemblnPorsi() {
        return pemblnPorsi;
    }
}
