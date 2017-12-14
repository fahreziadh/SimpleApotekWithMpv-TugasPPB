package com.fahrezi.apoteku.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class Obat implements Parcelable {
    String nama_obat;
    int stok_obat;
    int harga_obat;
    String id_obat;

    public Obat(String id_obat, String nama_obat, int stok_obat, int harga_obat) {
        this.nama_obat = nama_obat;
        this.stok_obat = stok_obat;
        this.harga_obat = harga_obat;
        this.id_obat = id_obat;
    }

    public void setId_obat(String id_obat) {
        this.id_obat = id_obat;
    }

    public String getId_obat() {
        return id_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public int getStok_obat() {
        return stok_obat;
    }

    public void setStok_obat(int stok_obat) {
        this.stok_obat = stok_obat;
    }

    public int getHarga_obat() {
        return harga_obat;
    }

    public void setHarga_obat(int harga_obat) {
        this.harga_obat = harga_obat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_obat);
        dest.writeInt(this.stok_obat);
        dest.writeInt(this.harga_obat);
        dest.writeString(this.id_obat);
    }

    protected Obat(Parcel in) {
        this.nama_obat = in.readString();
        this.stok_obat = in.readInt();
        this.harga_obat = in.readInt();
        this.id_obat = in.readString();
    }

    public static final Parcelable.Creator<Obat> CREATOR = new Parcelable.Creator<Obat>() {
        @Override
        public Obat createFromParcel(Parcel source) {
            return new Obat(source);
        }

        @Override
        public Obat[] newArray(int size) {
            return new Obat[size];
        }
    };
}
