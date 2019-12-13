package com.example.projectuas.CRUDDataDosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectuas.Adapter.ADosenActivity;
import com.example.projectuas.CRUDMatkul.LihatMatkulActivity;
import com.example.projectuas.Model.DefaultResult;
import com.example.projectuas.Model.MDosenActivity;
import com.example.projectuas.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.projectuas.Network.GetDataService;
import com.example.projectuas.Network.RetrofitClientInstance;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class LihatDataDosenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ADosenActivity ADosenActivity;
    private ArrayList<MDosenActivity> dosenArrayList;
    private List<MDosenActivity> dosenList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_dosen);



        recyclerView = findViewById(R.id.rvDsn);



//        Button btnCreate =(Button)findViewById(R.id.btn);

//        btnCreate.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent i = new Intent(Lihat.this,InsertUpdateDataDiriDosenActivity.class);
//                startActivity(i);
//            }
//        });

        //addData();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Load..");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class);
        Call<ArrayList<MDosenActivity>> call = service.getDosenAll("72170091");
        call.enqueue(new Callback<ArrayList<MDosenActivity>>() {
            @Override
            public void onResponse(Call<ArrayList<MDosenActivity>> call, Response<ArrayList<MDosenActivity>> response) {
                progressDialog.dismiss();

                dosenList = response.body();
                recyclerView = (RecyclerView)findViewById(R.id.rvDsn);
                ADosenActivity = new ADosenActivity(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(ADosenActivity);

            }

            @Override
            public void onFailure(Call<ArrayList<MDosenActivity>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LihatDataDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT);
            }
        });


        registerForContextMenu(recyclerView);

        ADosenActivity = new ADosenActivity(dosenArrayList);
        List<MDosenActivity> dosenList;

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataDosenActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ADosenActivity);

//        CRUDDOSENAdapter = new CRUDDOSENAdapter(crudArrayList);
//        List<CRUDDosen> crudDosenList;
        //mahasiswaAdapter = new MahasiswaAdapter(List);


    }
//    private void addData(){
//        crudArrayList = new ArrayList<>();
//        crudArrayList.add(new CRUDDosen("S.Kom","KatonWijana@gmail.com","JOGJA",R.drawable.xx));
    //     crudArrayList.add(new CRUDDosen("S.Ko","m@gmail.com","JOGJA",R.drawable.xx));
    //     crudArrayList.add(new CRUDDosen("S.Km","m@gmail.com","JOGJA",R.drawable.xx));
    //     crudArrayList.add(new CRUDDosen("S.Kll","mo@gmail.com","JOGJA",R.drawable.xx));
    //  crudArrayList.add(new CRUDDosen("S.Km","monica@gmail.com","JOGJA",R.drawable.xx));
//

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        MDosenActivity dosen = dosenList.get(item.getGroupId());
        if (item.getTitle() == "Ubah Data Dosen") {
            Intent intent = new Intent(LihatDataDosenActivity.this, LihatDataDosenActivity.class);
            intent.putExtra("id_dosen", dosen.getIdDsn());
            intent.putExtra("nama_dosen", dosen.getNamaDsn());
            intent.putExtra("nidn_dosen", dosen.getNidnDsn());
            intent.putExtra("alamat_dosen", dosen.getAlamatDsn());
            intent.putExtra("email_dosen", dosen.getEmailDsn());
            intent.putExtra("gelar_dosen", dosen.getGelarDsn());
            intent.putExtra("foto_dosen", dosen.getAndroidImage());
            intent.putExtra("is_update", true);
            startActivity(intent);
        } else if (item.getTitle() == "Hapus Data Dosen") {
            progressDialog = new ProgressDialog(LihatDataDosenActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(
                    dosen.getIdDsn(), "72170091");

            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(LihatDataDosenActivity.this, "Berhasil Hapus Dosen", Toast.LENGTH_SHORT);
                    Intent i = new Intent(LihatDataDosenActivity.this, LihatDataDosenActivity.class);
                    finish();

                    startActivity(i);
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    Toast.makeText(LihatDataDosenActivity.this, "Gagal Hapus Dosen", Toast.LENGTH_SHORT);

                }
            });
        }

        return super.onContextItemSelected(item);
    }
}






