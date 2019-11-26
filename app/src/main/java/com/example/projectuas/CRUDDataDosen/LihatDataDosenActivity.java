package com.example.projectuas.CRUDDataDosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectuas.Adapter.ADosenActivity;
import com.example.projectuas.CRUDMatkul.LihatMatkulActivity;
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
    private ArrayList<MDosenActivity> crudArrayList;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_dosen);

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

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<MDosenActivity>> call = service.getDosenAll("72170133");
        call.enqueue(new Callback<ArrayList<MDosenActivity>>() {
            @Override
            public void onResponse(Call<ArrayList<MDosenActivity>> call, Response<ArrayList<MDosenActivity>> response) {
                progressDialog.dismiss();
                recyclerView = findViewById(R.id.rvDsn);
                ADosenActivity = new ADosenActivity(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(ADosenActivity);

            }

            @Override
            public void onFailure(Call<ArrayList<MDosenActivity>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LihatDataDosenActivity.this,"Login Gagal", Toast.LENGTH_SHORT);
            }
        });


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

}
