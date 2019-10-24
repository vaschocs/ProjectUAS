package com.example.projectuas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.Model.MDosenActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class ADosenActivity extends RecyclerView.Adapter<ADosenActivity.ViewHolder>{
    public ADosenActivity(ArrayList<MDosenActivity> DsnArrayList) {
        this.DsnArrayList = DsnArrayList;
    }
    private ArrayList<MDosenActivity> DsnArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.card_view_dsn,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageViewDsn.setImageResource(DsnArrayList.get(position).getAndroidImage());
        holder.txtnindDsn.setText(DsnArrayList.get(position).getNidnDsn());
        holder.txtnamaDsn.setText(DsnArrayList.get(position).getNamaDsn());
        holder.txtgelarDsn.setText(DsnArrayList.get(position).getGelarDsn());
        holder.txtemailDsn.setText(DsnArrayList.get(position).getEmailDsn());
        holder.txtalamatDsn.setText(DsnArrayList.get(position).getAlamatDsn());
    }

    @Override
    public int getItemCount() {
        return (DsnArrayList !=null)?DsnArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewDsn;
        private TextView txtnindDsn, txtnamaDsn, txtgelarDsn, txtemailDsn, txtalamatDsn;
        public ViewHolder(View view){
            super(view);
            imageViewDsn = view.findViewById(R.id.image_Dsn);
            txtnindDsn= view.findViewById(R.id.txt_nama_Dsn);
            txtnamaDsn=view.findViewById(R.id.txt_nama_Dsn);
            txtgelarDsn=view.findViewById(R.id.txt_gelar_Dsn);
            txtemailDsn=view.findViewById(R.id.txt_email_Dsn);
            txtalamatDsn=view.findViewById(R.id.txt_alamat_Dsn);
        }

    }
}