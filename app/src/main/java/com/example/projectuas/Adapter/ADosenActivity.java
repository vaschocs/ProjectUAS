package com.example.projectuas.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.Model.MDosenActivity;
import com.example.projectuas.Model.MDosenActivity;
import com.example.projectuas.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ADosenActivity extends RecyclerView.Adapter<ADosenActivity.ViewHolder> {
    private Context context;
    private ArrayList<MDosenActivity> dosenArrayList;
    public ADosenActivity(ArrayList<MDosenActivity> dosenArrayList) {
        this.dosenArrayList = dosenArrayList;


    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_dsn,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgdos.getLayoutParams().width=150;
        holder.imgdos.getLayoutParams().height=150;
        if(dosenArrayList.get(position).getAndroidImage()!=null){
            Picasso.with(this.context).
                    load("https://kpsi.fti.ukdw.ac.id/progmob/"+dosenArrayList.get(position).getAndroidImage())
//                    .transform(new CropCircleTransformation())//pakai library tambahan jp.picasso di gradle-> utk ubah bentuk gambar crop lingkaran
                    .into(holder.imgdos);
        }

        holder.txtNIDN.setText(dosenArrayList.get(position).getNidnDsn());
        holder.txtNama.setText(dosenArrayList.get(position).getNamaDsn());
        holder.txtGelar.setText(dosenArrayList.get(position).getGelarDsn());
        holder.txtEmail.setText(dosenArrayList.get(position).getEmailDsn());
        holder.txtAlamat.setText(dosenArrayList.get(position).getAlamatDsn());


//        holder.imgdos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Nama = dosenArrayList.get(position).getAlamat().toString();
//                Toast.makeText(context, Nama + " is selected", Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return (dosenArrayList != null) ? dosenArrayList.size() : 0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    implements View.OnCreateContextMenuListener{
        private TextView txtGelar, txtEmail, txtAlamat, txtNama, txtNIDN;
        ImageView imgdos;

        public ViewHolder(View view) {
            super(view);
            txtNama = view.findViewById(R.id.txt_nama_Dsn);
            txtNIDN = view.findViewById(R.id.txt_nind_Dsn);
            imgdos = view.findViewById(R.id.image_Dsn);
            txtGelar = view.findViewById(R.id.txt_gelar_Dsn);
            txtEmail = view.findViewById(R.id.txt_email_Dsn);
            txtAlamat = view.findViewById(R.id.txt_alamat_Dsn);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Pilih Aksi");
            menu.add(this.getAdapterPosition(), v.getId(), 0, "Ubah Data Dosen");
            menu.add(this.getAdapterPosition(), v.getId(), 0, "Hapus Data Dosen");
        }



    }
}