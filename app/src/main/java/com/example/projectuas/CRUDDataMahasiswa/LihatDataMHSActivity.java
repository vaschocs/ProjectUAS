package com.example.projectuas.CRUDDataMahasiswa;

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

import com.example.projectuas.Adapter.AMahasiswaActivity;
import com.example.projectuas.CRUDMatkul.LihatMatkulActivity;
import com.example.projectuas.Model.DefaultResult;
import com.example.projectuas.Model.MMahasiswaActivity;
import com.example.projectuas.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.projectuas.Networkm.GetDataService;
import com.example.projectuas.Networkm.RetrofitClientInstance;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class LihatDataMHSActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AMahasiswaActivity AMahasiswaActivity;
    private ArrayList<MMahasiswaActivity> mhsArrayList;
    private List<MMahasiswaActivity> mhsList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_mhs);



        recyclerView = findViewById(R.id.rvMhs);




        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Load..");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class);
        Call<ArrayList<MMahasiswaActivity>> call = service.getMhsAll("72170091");
        call.enqueue(new Callback<ArrayList<MMahasiswaActivity>>() {
            @Override
            public void onResponse(Call<ArrayList<MMahasiswaActivity>> call, Response<ArrayList<MMahasiswaActivity>> response) {
                progressDialog.dismiss();

                mhsList = response.body();
                recyclerView = (RecyclerView)findViewById(R.id.rvMhs);
                AMahasiswaActivity = new AMahasiswaActivity(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataMHSActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(AMahasiswaActivity);

            }

            @Override
            public void onFailure(Call<ArrayList<MMahasiswaActivity>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LihatDataMHSActivity.this, "Login Gagal", Toast.LENGTH_SHORT);
            }
        });


        registerForContextMenu(recyclerView);

        AMahasiswaActivity = new AMahasiswaActivity(mhsArrayList);
        List<MMahasiswaActivity> mhsList;

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataMHSActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(AMahasiswaActivity);



    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        MMahasiswaActivity mhs = mhsList.get(item.getGroupId());
        if (item.getTitle() == "Ubah Data Mahasiswa") {
            Intent intent = new Intent(LihatDataMHSActivity.this, LihatDataMHSActivity.class);
            intent.putExtra("id_mhs", mhs.getIdMhs());
            intent.putExtra("nama_mhs", mhs.getNamaMhs());
            intent.putExtra("nim_mhs", mhs.getNimMhs());
            intent.putExtra("alamat_mhs", mhs.getAlamatMhs());
            intent.putExtra("email_mhs", mhs.getEmailMhs());
            intent.putExtra("foto_mhs", mhs.getAndroidImage());
            intent.putExtra("is_update", true);
            startActivity(intent);
        } else if (item.getTitle() == "Hapus Data Mahasiswa") {
            progressDialog = new ProgressDialog(LihatDataMHSActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_mhs(
                    mhs.getIdMhs(), "72170091");

            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(LihatDataMHSActivity.this, "Berhasil Hapus Mahasiswa", Toast.LENGTH_SHORT);
                    Intent i = new Intent(LihatDataMHSActivity.this, LihatDataMHSActivity.class);
                    finish();

                    startActivity(i);
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    Toast.makeText(LihatDataMHSActivity.this, "Gagal Hapus Mahasiswa", Toast.LENGTH_SHORT);

                }
            });
        }

        return super.onContextItemSelected(item);
    }
}






