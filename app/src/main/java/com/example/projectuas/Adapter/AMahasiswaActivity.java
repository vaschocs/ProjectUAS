package com.example.projectuas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.Model.MMahasiswaActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class AMahasiswaActivity extends RecyclerView.Adapter<AMahasiswaActivity.ViewHolder>{
    public AMahasiswaActivity(ArrayList<MMahasiswaActivity> MhsArrayList) {
        this.MhsArrayList = MhsArrayList;
    }
    private ArrayList<MMahasiswaActivity> MhsArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.card_view_mhs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageViewMhs.setImageResource(MhsArrayList.get(position).getAndroidImage());
        holder.txtnimMhs.setText(MhsArrayList.get(position).getNimMhs());
        holder.txtnamaMhs.setText(MhsArrayList.get(position).getNamaMhs());
        holder.txtemailMhs.setText(MhsArrayList.get(position).getEmailMhs());
        holder.txtalamatMhs.setText(MhsArrayList.get(position).getAlamatMhs());
    }

    @Override
    public int getItemCount() {
        return (MhsArrayList !=null)?MhsArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewMhs;
        private TextView txtnimMhs, txtnamaMhs, txtgelarMhs, txtemailMhs, txtalamatMhs;
        public ViewHolder(View view){
            super(view);
            imageViewMhs = view.findViewById(R.id.image_Mhs);
            txtnimMhs= view.findViewById(R.id.txt_kode_matkul);
            txtnamaMhs=view.findViewById(R.id.txt_nama_matkul);
            txtemailMhs=view.findViewById(R.id.txt_hari_matkul);
            txtalamatMhs=view.findViewById(R.id.txt_sesi_matkkul);
        }

    }
}