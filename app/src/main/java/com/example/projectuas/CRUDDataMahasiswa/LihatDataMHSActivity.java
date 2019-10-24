package com.example.projectuas.CRUDDataMahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuas.Adapter.AMahasiswaActivity;
import com.example.projectuas.Model.MMahasiswaActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class LihatDataMHSActivity extends AppCompatActivity {
    RecyclerView rvMhs;
    private RecyclerView recyclerView;
    private AMahasiswaActivity mahasiswaAdapter;
    private ArrayList<MMahasiswaActivity> mhsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_mhs);
        addData();
        recyclerView = findViewById(R.id.rvMhs);
        mahasiswaAdapter = new AMahasiswaActivity(mhsArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(LihatDataMHSActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);

        RecyclerView rvMhs = (RecyclerView) findViewById(R.id.rvMhs);

        rvMhs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(LihatDataMHSActivity.this,InsertUpdateDataDiriMHSActivity.class);
                startActivity(i);
            }
        });


    }

    private void addData(){
        mhsArrayList = new ArrayList<>();
        mhsArrayList.add(new MMahasiswaActivity(R.drawable.ic_launcher_background,"NIM Mahasiswa",
                "Nama Mahasiswa", "e-mail Mahaasiswa", "Alamat Mahasiswa"));




    }


}


