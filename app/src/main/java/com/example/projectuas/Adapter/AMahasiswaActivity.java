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

import com.example.projectuas.Model.MMahasiswaActivity;
import com.example.projectuas.Model.MMahasiswaActivity;
import com.example.projectuas.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AMahasiswaActivity extends RecyclerView.Adapter<AMahasiswaActivity.ViewHolder> {
    private Context context;
    private ArrayList<MMahasiswaActivity> mhsArrayList;
    public AMahasiswaActivity(ArrayList<MMahasiswaActivity> mhsArrayList) {
        this.mhsArrayList = mhsArrayList;


    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_mhs,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgdos.getLayoutParams().width = 150;
        holder.imgdos.getLayoutParams().height = 150;
        if (mhsArrayList.get(position).getAndroidImage() != null) {
            Picasso.with(this.context).
                    load("https://kpsi.fti.ukdw.ac.id/progmob/" + mhsArrayList.get(position).getAndroidImage())
//                    .transform(new CropCircleTransformation())//pakai library tambahan jp.picasso di gradle-> utk ubah bentuk gambar crop lingkaran
                    .into(holder.imgdos);
        }

        holder.txtNIM.setText(mhsArrayList.get(position).getNimMhs());
        holder.txtNama.setText(mhsArrayList.get(position).getNamaMhs());
        holder.txtEmail.setText(mhsArrayList.get(position).getEmailMhs());
        holder.txtAlamat.setText(mhsArrayList.get(position).getAlamatMhs());
    }

    @Override
    public int getItemCount() {
        return (mhsArrayList != null) ? mhsArrayList.size() : 0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener{
        private TextView txtGelar, txtEmail, txtAlamat, txtNama, txtNIM;
        ImageView imgdos;

        public ViewHolder(View view) {
            super(view);
            txtNama = view.findViewById(R.id.txt_nama_Mhs);
            txtNIM = view.findViewById(R.id.txt_nim_Mhs);
            imgdos = view.findViewById(R.id.image_Mhs);
            txtEmail = view.findViewById(R.id.txt_email_Mhs);
            txtAlamat = view.findViewById(R.id.txt_alamat_Mhs);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Pilih Aksi");
            menu.add(this.getAdapterPosition(), v.getId(), 0, "Ubah Data Mahasiswa");
            menu.add(this.getAdapterPosition(), v.getId(), 0, "Hapus Data Mahasiswa");
        }



    }
}