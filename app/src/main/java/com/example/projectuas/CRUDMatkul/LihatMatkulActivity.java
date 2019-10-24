package com.example.projectuas.CRUDMatkul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuas.Adapter.AMatkulActivity;
import com.example.projectuas.Model.MMatkulActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class LihatMatkulActivity extends AppCompatActivity {
    RecyclerView rvMkl;
    private RecyclerView recyclerView;
    private AMatkulActivity matkulAdapter;
    private ArrayList<MMatkulActivity> mklArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_matkul);
        addData();
        recyclerView = findViewById(R.id.rvMkl);
        matkulAdapter = new AMatkulActivity(mklArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(LihatMatkulActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(matkulAdapter);

        RecyclerView rvMkl = (RecyclerView) findViewById(R.id.rvMkl);

        rvMkl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(LihatMatkulActivity.this,InsertUpdateMatkulActivity.class);
                startActivity(i);
            }
        });


    }

    private void addData(){
        mklArrayList = new ArrayList<>();
        mklArrayList.add(new MMatkulActivity("Kode Matkul",
                "Nama Matkul", "Hari Matkul", "Sesi Matkul","Jumlah SKS Matkul"));




    }


}


