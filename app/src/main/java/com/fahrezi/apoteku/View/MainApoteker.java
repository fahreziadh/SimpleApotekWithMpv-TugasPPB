package com.fahrezi.apoteku.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fahrezi.apoteku.Model.Pesanan;
import com.fahrezi.apoteku.Model.Resep;
import com.fahrezi.apoteku.R;
import com.fahrezi.apoteku.adapter.MainApotekerAdapter;
import com.fahrezi.apoteku.adapter.sqlite_adapter;

import java.util.ArrayList;

public class MainApoteker extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<Resep> reseps;
    int lunas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_apoteker);
        render();
        getReseps();
    }

    public void render() {
        reseps = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apoteku");
        setSupportActionBar(toolbar);
        recycler = findViewById(R.id.recycler_apotek);
        manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        adapter = new MainApotekerAdapter(reseps, lunas);
        recycler.setAdapter(adapter);
    }

    public void getReseps() {

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pesanan:
                break;
            case R.id.obat:
                Intent intent = new Intent(MainApoteker.this, obat.class);
                startActivity(intent);
                break;
            case R.id.logout:
                sqlite_adapter dbku = new sqlite_adapter(this);
                Cursor c = dbku.cek_login();
                c.moveToNext();
                if (dbku.logout(c.getString(0))) {
                    finish();
                    Intent i=new Intent(this,login.class);
                    startActivity(i);
                }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_apotek, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
