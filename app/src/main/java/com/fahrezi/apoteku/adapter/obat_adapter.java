package com.fahrezi.apoteku.adapter;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fahrezi.apoteku.Model.Obat;
import com.fahrezi.apoteku.Precenter.removeObat_interface;
import com.fahrezi.apoteku.Precenter.removeObat_precenter;
import com.fahrezi.apoteku.R;
import com.fahrezi.apoteku.View.obat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class obat_adapter extends RecyclerView.Adapter<obat_adapter.ViewHolder> {
    List<Obat> data = new ArrayList<>();

    public obat_adapter(List<Obat> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obat, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.getNama_obat().setText(data.get(position).getNama_obat());
        holder.getHarga_obat().setText(String.valueOf(NumberFormat.getCurrencyInstance().format(data.get(position).getHarga_obat())));
        holder.getStok().setText(String.valueOf(data.get(position).getStok_obat()) + "pcs");
        holder.getNo().setText(String.valueOf(position + 1));
        holder.getClick().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                View detail = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.detail_obat, null, false);
                final TextView nama = detail.findViewById(R.id.nama);
                final TextView stok = detail.findViewById(R.id.stok);
                TextView hapus = detail.findViewById(R.id.hapus);
                TextView kembali = detail.findViewById(R.id.kembali);
                final ImageView edit = detail.findViewById(R.id.edit);
                nama.setText(holder.getNama_obat().getText().toString());
                stok.setText(holder.getStok().getText().toString());
                builder.setView(detail);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                kembali.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                hapus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        removeObat_precenter removeObatPrecenter = new removeObat_precenter(new removeObat_interface() {
                            @Override
                            public void respone(String response) {
                                data.remove(position);
                                notifyDataSetChanged();
                                alertDialog.dismiss();
                            }
                        });
                        removeObatPrecenter.remove(data.get(position).getId_obat());
                    }
                });
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        View v_ = LayoutInflater.from(view.getContext()).inflate(R.layout.edit_obat, null, false);
                        EditText nama_obat = v_.findViewById(R.id.nama_obat);
                        EditText harga_obat = v_.findViewById(R.id.harga_obat);
                        EditText stock_obat = v_.findViewById(R.id.stok_obat);
                        TextView tambahkan = v_.findViewById(R.id.tambahkan);
                        nama_obat.setText(nama.getText().toString());
                        harga_obat.setText(holder.getHarga_obat().getText().toString());
                        stock_obat.setText(stok.getText().toString());
                        builder.setView(v_);
                        final AlertDialog dialog = builder.create();
                        dialog.show();
                        tambahkan.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            dialog.dismiss();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView harga_obat, nama_obat, stok, no;
        LinearLayout click;

        public ViewHolder(View v) {
            super(v);
            no = v.findViewById(R.id.no);
            harga_obat = v.findViewById(R.id.harga_obat);
            nama_obat = v.findViewById(R.id.nama_obat);
            stok = v.findViewById(R.id.stok);
            click = v.findViewById(R.id.click);
        }

        public LinearLayout getClick() {
            return click;
        }

        public TextView getNo() {
            return no;
        }

        public TextView getHarga_obat() {
            return harga_obat;
        }

        public TextView getNama_obat() {
            return nama_obat;
        }

        public TextView getStok() {
            return stok;
        }
    }
}
