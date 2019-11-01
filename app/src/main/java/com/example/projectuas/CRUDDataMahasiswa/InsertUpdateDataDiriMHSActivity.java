package com.example.projectuas.CRUDDataMahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectuas.HomeScreenAdminActivity;
import com.example.projectuas.LoginScreenActivity;
import com.example.projectuas.R;

public class InsertUpdateDataDiriMHSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_data_diri_dosen);
        Button simpanButton = findViewById(R.id.simpanButton);
        Button browseButton = findViewById(R.id.browseButton);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(InsertUpdateDataDiriMHSActivity.this);
                builder.setMessage("Apakah anda yakin untuk  menyimpan?")
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick (DialogInterface dialog,int which){
                                Toast.makeText(InsertUpdateDataDiriMHSActivity.this, "Tidak jadi menyimpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int which){
                        Intent i = new Intent(InsertUpdateDataDiriMHSActivity.this, HomeScreenAdminActivity.class);
                        startActivity(i);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InsertUpdateDataDiriMHSActivity.this,LihatDataMHSActivity.class);
                startActivity(intent);
            }
        });

    }
}
