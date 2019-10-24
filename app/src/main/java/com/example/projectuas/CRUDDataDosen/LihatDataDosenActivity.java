package com.example.projectuas.CRUDDataDosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuas.Adapter.ADosenActivity;
import com.example.projectuas.Model.MDosenActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class LihatDataDosenActivity extends AppCompatActivity {
    RecyclerView rvDsn;
    private RecyclerView recyclerView;
    private ADosenActivity dosenAdapter;
    private ArrayList<MDosenActivity> dsnArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_dosen);
        addData();
        recyclerView = findViewById(R.id.rvDsn);
        dosenAdapter = new ADosenActivity(dsnArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(LihatDataDosenActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dosenAdapter);

        RecyclerView rvDsn = (RecyclerView) findViewById(R.id.rvDsn);

        rvDsn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(LihatDataDosenActivity.this,InsertUpdateDataDiriDosenActivity.class);
                startActivity(i);
            }
        });


    }

    private void addData(){
        dsnArrayList = new ArrayList<>();
        dsnArrayList.add(new MDosenActivity(R.drawable.ic_launcher_background,"NIDN Dosen",
                "Nama Dosen", "Gelar Dosen", "e-mail Dosen","Alamat Dosen"));




    }


}


