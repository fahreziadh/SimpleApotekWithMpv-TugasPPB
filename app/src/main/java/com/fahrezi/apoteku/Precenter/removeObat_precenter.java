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

public class removeObat_precenter {
    removeObat_interface removeObat_interface;

    public removeObat_precenter(com.fahrezi.apoteku.Precenter.removeObat_interface removeObat_interface) {
        this.removeObat_interface = removeObat_interface;
    }

    public void remove(String id) {
        AndroidNetworking.post(Global.link + "remove_obat.php")
                .addBodyParameter("id",id)
                .setPriority(Priority.HIGH)
                .build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                removeObat_interface.respone(response);
            }

            @Override
            public void onError(ANError anError) {

            }
        });
    }
}
