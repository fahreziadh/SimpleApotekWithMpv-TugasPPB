package com.fahrezi.apoteku.View;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahrezi.apoteku.Model.Obat;
import com.fahrezi.apoteku.Precenter.addObat_interface;
import com.fahrezi.apoteku.Precenter.addObat_precenter;
import com.fahrezi.apoteku.Precenter.getObat_interface;
import com.fahrezi.apoteku.Precenter.getObat_precenter;
import com.fahrezi.apoteku.R;
import com.fahrezi.apoteku.adapter.obat_adapter;

import java.util.ArrayList;
import java.util.List;

public class obat extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    List<Obat> data = new ArrayList<>();
    Toolbar toolbar;
    getObat_precenter precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obat);
        render();
    }

    public void render() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Daftar Obat");
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_obat);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new obat_adapter(data);
        recyclerView.setAdapter(adapter);
        getData();
    }

    public void getData() {
        precenter = new getObat_precenter(new getObat_interface() {
            @Override
            public void getData(Obat b) {
                data.add(b);
                adapter.notifyDataSetChanged();
            }
        });
        precenter.obat();
    }

    public void tambah(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v_ = LayoutInflater.from(this).inflate(R.layout.tambah_obat, null, false);
        final EditText nama_obat = v_.findViewById(R.id.nama_obat);
        final EditText harga_obat = v_.findViewById(R.id.harga_obat);
        final EditText stock = v_.findViewById(R.id.stok_obat);
        TextView lanjutkan = v_.findViewById(R.id.tambahkan);
        builder.setView(v_);
        final AlertDialog dialog = builder.create();
        dialog.show();
        lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addObat_precenter tambah = new addObat_precenter(new addObat_interface() {
                    @Override
                    public void respon(String respone) {
                        if (respone != null) {
                            Obat b = new Obat(respone, nama_obat.getText().toString(), Integer.parseInt(stock.getText().toString()), Integer.parseInt(harga_obat.getText().toString()));
                            data.add(b);
                            adapter.notifyDataSetChanged();
                        } else {

                        }
                    }
                });
                tambah.addObat(nama_obat.getText().toString(), stock.getText().toString(), harga_obat.getText().toString());
                dialog.dismiss();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
