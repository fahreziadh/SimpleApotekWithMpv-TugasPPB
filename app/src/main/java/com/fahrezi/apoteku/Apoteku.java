package com.fahrezi.apoteku;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by fahrezi on 12/12/17.
 */

public class Apoteku extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
