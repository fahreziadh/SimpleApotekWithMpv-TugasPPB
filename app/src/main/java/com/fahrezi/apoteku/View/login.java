package com.fahrezi.apoteku.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fahrezi.apoteku.Model.User;
import com.fahrezi.apoteku.Precenter.auth_interface;
import com.fahrezi.apoteku.Precenter.auth_precenter;
import com.fahrezi.apoteku.R;
import com.fahrezi.apoteku.adapter.sqlite_adapter;

public class login extends AppCompatActivity implements auth_interface {

    EditText username, password;
    auth_precenter auth;
    sqlite_adapter dbku;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        render();
        cek_login();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void cek_login() {
        dbku = new sqlite_adapter(this);
        Cursor cek = dbku.cek_login();
        cek.moveToNext();
        if (cek.getCount() > 0) {
            if (cek.getInt(2) == 2) {
                Intent intent = new Intent(login.this, obat.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(login.this, MainUser.class);
                startActivity(intent);
            }
            finish();
        }
    }

    public void cek_kode(View view) {
        Intent intent = new Intent(login.this, MainUser.class);
        startActivity(intent);
    }

    public void render() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        auth = new auth_precenter(this);
    }

    public void login(View v) {
        auth.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void login(User u) {
        if (u == null) {
            Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
        } else {
            dbku.login(u.getUsername(), u.getPassword(), u.getLevel());
            if (u.getLevel() == 1) {

            } else if (u.getLevel() == 2) {
                Intent intent = new Intent(login.this, MainApoteker.class);
                startActivity(intent);
            }
            finish();
        }
    }
}
