package com.fahrezi.apoteku.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fahrezi.apoteku.Model.Resep;
import com.fahrezi.apoteku.R;
import com.fahrezi.apoteku.View.MainApoteker;

import java.util.ArrayList;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class MainApotekerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Resep> resep;
    int lunas;

    public MainApotekerAdapter(ArrayList<Resep> resep, int lunas) {
        this.resep = resep;
        this.lunas = lunas;
    }

    public static class header extends RecyclerView.ViewHolder {
        TextView belum_lunas, lunas, total;

        public header(View v) {
            super(v);
            belum_lunas = v.findViewById(R.id.belum_lunas);
            lunas = v.findViewById(R.id.lunas);
            total = v.findViewById(R.id.total);
        }

    }

    public static class main extends RecyclerView.ViewHolder {
        TextView status;
        TextView nama, no;

        public main(View v) {
            super(v);
            nama = v.findViewById(R.id.nama);
            status = v.findViewById(R.id.status);
            no = v.findViewById(R.id.no);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        else
            return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_main_apoteker, parent, false);
            return new header(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_apoteker, parent, false);
            return new main(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof header) {
            header item = (header) holder;
//            item.total.setText(String.valueOf(resep.size()));
//            item.lunas.setText(String.valueOf(lunas));
//            item.belum_lunas.setText(String.valueOf(resep.size() - lunas));
        } else if (holder instanceof main) {
            main item = (main) holder;
            item.nama.setText(resep.get(position - 1).getUser().toString());
            status_(item.status, resep.get(position - 1).getStatus());
            item.no.setText(String.valueOf(position));
        }
    }

    public void status_(TextView status, String getStatus) {
        status.setText(getStatus);

        if (getStatus == "Lunas") {
            status.setTextColor(Color.WHITE);
            status.setBackgroundResource(R.drawable.lunas);
        } else {
            status.setTextColor(Color.BLACK);
            status.setBackgroundResource(R.drawable.belum);
        }
    }

    @Override
    public int getItemCount() {
        return resep.size() + 1;
    }
}
