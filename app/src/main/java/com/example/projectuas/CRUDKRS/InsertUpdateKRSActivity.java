package com.example.projectuas.CRUDKRS;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectuas.CRUDDataMahasiswa.InsertUpdateDataDiriMHSActivity;
import com.example.projectuas.CRUDKRS.LihatKRSActivity;
import com.example.projectuas.HomeScreenAdminActivity;
import com.example.projectuas.R;

public class InsertUpdateKRSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_krs);
        Button simpanButton = findViewById(R.id.simpanButton);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(InsertUpdateKRSActivity.this);
                builder.setMessage("Apakah anda yakin untuk  menyimpan?")
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick (DialogInterface dialog,int which){
                                Toast.makeText(InsertUpdateKRSActivity.this, "Tidak jadi menyimpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int which){
                        Intent i = new Intent(InsertUpdateKRSActivity.this, HomeScreenAdminActivity.class);
                        startActivity(i);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InsertUpdateKRSActivity.this, LihatKRSActivity.class);
                startActivity(intent);
            }
        });

    }
}
