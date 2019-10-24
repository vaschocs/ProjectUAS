package com.example.projectuas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.Model.MKRSActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class AKRSActivity extends RecyclerView.Adapter<AKRSActivity.ViewHolder>{
    public AKRSActivity(ArrayList<MKRSActivity> KrsArrayList) {
        this.KrsArrayList = KrsArrayList;
    }
    private ArrayList<MKRSActivity> KrsArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.card_view_krs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtkodeMatkulK.setText(KrsArrayList.get(position).getKodeMatkulK());
        holder.txtnamaMatkulK.setText(KrsArrayList.get(position).getNamaMatkulK());
        holder.txthariMatkulK.setText(KrsArrayList.get(position).getHariMatkulK());
        holder.txtjmlSKSK.setText(KrsArrayList.get(position).getJmlSKSK());
        holder.txtdsnPengampuK.setText(KrsArrayList.get(position).getDsnPengampuK());
        holder.txtjmlMHSK.setText(KrsArrayList.get(position).getJmlMHSK());
    }

    @Override
    public int getItemCount() {
        return (KrsArrayList !=null)?KrsArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtkodeMatkulK, txtnamaMatkulK, txthariMatkulK, txtjmlSKSK, txtdsnPengampuK, txtjmlMHSK;
        public ViewHolder(View view){
            super(view);
            txtkodeMatkulK= view.findViewById(R.id.txt_kode_matkul_k);
            txtnamaMatkulK=view.findViewById(R.id.txt_nama_matkul_k);
            txthariMatkulK=view.findViewById(R.id.txt_hari_matkul_k);
            txtjmlSKSK=view.findViewById(R.id.txt_jml_sks_k);
            txtdsnPengampuK=view.findViewById(R.id.txt_dsn_pengampu_k);
            txtjmlMHSK=view.findViewById(R.id.txt_jml_mhs_k);
        }

    }
}