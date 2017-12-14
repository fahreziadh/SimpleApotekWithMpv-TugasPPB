package com.fahrezi.apoteku.Precenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.fahrezi.apoteku.Global;
import com.fahrezi.apoteku.Model.Obat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class addObat_precenter {
    addObat_interface obatinterface;

    public addObat_precenter(addObat_interface obatinterface) {
        this.obatinterface = obatinterface;
    }

    public void addObat(String nama, String stok, String harga) {
        AndroidNetworking.post(Global.link + "add_obat.php")
                .addBodyParameter("nama", nama)
                .addBodyParameter("stok", stok)
                .addBodyParameter("harga", harga)
                .setPriority(Priority.HIGH)
                .build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                    obatinterface.respon(response);
            }

            @Override
            public void onError(ANError anError) {
            }
        });

    }

}
