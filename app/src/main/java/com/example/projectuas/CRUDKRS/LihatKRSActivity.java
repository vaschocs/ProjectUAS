package com.example.projectuas.CRUDKRS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuas.Adapter.AKRSActivity;
import com.example.projectuas.Model.MKRSActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class LihatKRSActivity extends AppCompatActivity {
    RecyclerView rvKrs;
    private RecyclerView recyclerView;
    private AKRSActivity krsAdapter;
    private ArrayList<MKRSActivity> krsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_krs);
        addData();
        recyclerView = findViewById(R.id.rvKrs);
        krsAdapter = new AKRSActivity(krsArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(LihatKRSActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);

        RecyclerView rvKrs = (RecyclerView) findViewById(R.id.rvKrs);

        rvKrs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(LihatKRSActivity.this,InsertUpdateKRSActivity.class);
                startActivity(i);
            }
        });


    }

    private void addData(){
        krsArrayList = new ArrayList<>();
        krsArrayList.add(new MKRSActivity("Kode Matkul",
                "Nama Matkul", "Hari Matkul", "Jumlah SKS","Dosen Pengampu","Jumlah Mahasiswa"));




    }


}


