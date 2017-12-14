package com.fahrezi.apoteku.Precenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.fahrezi.apoteku.Global;
import com.fahrezi.apoteku.Model.User;
import com.fahrezi.apoteku.adapter.sqlite_adapter;

import org.json.JSONArray;

/**
 * Created by fahrezi on 12/12/17.
 */

public class auth_precenter {
    auth_interface auth;

    public auth_precenter(auth_interface auth) {
        this.auth = auth;
    }

    public void login(final String username, final String password) {
        AndroidNetworking.post(Global.link + "auth.php")
                .addBodyParameter("user",username)
                .addBodyParameter("pass",password)
                .setPriority(Priority.HIGH)
                .build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                Log.d("", "onResponse: " + response);
                if (!response.equals("")) {
                    auth.login(new User(username, password, Integer.parseInt(response)));
                } else {
                    auth.login(null);
                }
            }

            @Override
            public void onError(ANError anError) {
                auth.login(null);
            }
        });
    }

}
