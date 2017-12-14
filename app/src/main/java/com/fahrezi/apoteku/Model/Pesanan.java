package com.fahrezi.apoteku.Model;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class Pesanan {
    int id_obat;
    String nama_obat;
    int harga;
    int jumlah;

    public Pesanan(int id_obat, String nama_obat, int harga, int jumlah) {
        this.id_obat = id_obat;
        this.nama_obat = nama_obat;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
