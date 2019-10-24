package com.example.projectuas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projectuas.Model.MMatkulActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class AMatkulActivity extends RecyclerView.Adapter<AMatkulActivity.ViewHolder>{
    public AMatkulActivity(ArrayList<MMatkulActivity> MklArrayList) {
        this.MklArrayList = MklArrayList;
    }
    private ArrayList<MMatkulActivity> MklArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.card_view_mkl,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtkodeMatkul.setText(MklArrayList.get(position).getKodeMatkul());
        holder.txtnamaMatkul.setText(MklArrayList.get(position).getNamaMatkul());
        holder.txthariMatkul.setText(MklArrayList.get(position).getHariMatkul());
        holder.txtsesiMatkul.setText(MklArrayList.get(position).getSesiMatkul());
        holder.txtjmlSKSMatkul.setText(MklArrayList.get(position).getJmlSKSMatkul());
    }

    @Override
    public int getItemCount() {
        return (MklArrayList !=null)?MklArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtkodeMatkul,txtnamaMatkul,txthariMatkul,txtsesiMatkul, txtjmlSKSMatkul;
        public ViewHolder(View view){
            super(view);
            txtkodeMatkul= view.findViewById(R.id.txt_kode_matkul);
            txtnamaMatkul=view.findViewById(R.id.txt_nama_matkul);
            txthariMatkul=view.findViewById(R.id.txt_hari_matkul);
            txtsesiMatkul=view.findViewById(R.id.txt_sesi_matkkul);
            txtjmlSKSMatkul=view.findViewById(R.id.txt_jml_sks_matkkul);
        }

    }
}