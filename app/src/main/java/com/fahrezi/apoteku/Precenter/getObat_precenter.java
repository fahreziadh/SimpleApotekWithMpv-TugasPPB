package com.fahrezi.apoteku.Precenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.fahrezi.apoteku.Global;
import com.fahrezi.apoteku.Model.Obat;
import com.fahrezi.apoteku.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class getObat_precenter {

    getObat_interface value;
    public getObat_precenter(getObat_interface value) {
        this.value = value;
    }


    public void obat() {
        AndroidNetworking.post(Global.link + "get_obat.php")
                .setPriority(Priority.HIGH)
                .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("", "onResponse: "+response.toString());
                try {
                    JSONArray jsonArray = response.getJSONArray("obat");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Obat b = new Obat(object.getString("id_obat"), object.getString("nama_obat"), object.getInt("stok_obat"), object.getInt("harga_obat"));
                        value.getData(b);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("", "onResponse: "+e.getMessage());
                }

            }

            @Override
            public void onError(ANError anError) {
                value.getData(null);
            }
        });
    }


}
