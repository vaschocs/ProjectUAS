package com.example.projectuas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projectuas.CRUDDataDosen.InsertUpdateDataDiriDosenActivity;
import com.example.projectuas.CRUDDataDosen.LihatDataDosenActivity;
import com.example.projectuas.CRUDDataMahasiswa.InsertUpdateDataDiriMHSActivity;
import com.example.projectuas.CRUDDataMahasiswa.LihatDataMHSActivity;
import com.example.projectuas.CRUDKRS.InsertUpdateKRSActivity;
import com.example.projectuas.CRUDKRS.LihatKRSActivity;



public class HomeScreenAdminActivity extends AppCompatActivity {
    ImageButton ddaBtn;
    ImageButton dkrsaBtn;
    ImageButton dmhsaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_admin);

        ImageButton ddaBtn = (ImageButton) findViewById(R.id.ddaBtn);
        ImageButton dkrsa = (ImageButton) findViewById(R.id.dkrsaBtn);
        ImageButton dmhsa = (ImageButton) findViewById(R.id.dmhsaBtn);
        Button btnlogout = (Button) findViewById(R.id.btnlogout);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeScreenAdminActivity.this);
            builder.setMessage("Apakah anda yakin untuk  logout?")
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                public void onClick (DialogInterface dialog,int which){
                    Toast.makeText(HomeScreenAdminActivity.this, "Tidak jadi logout",
                            Toast.LENGTH_SHORT).show();
                }
            }).setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                public void onClick (DialogInterface dialog,int which){
                    Intent i = new Intent(HomeScreenAdminActivity.this, LoginScreenActivity.class);
                    startActivity(i);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    });


        ddaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenAdminActivity.this, InsertUpdateDataDiriDosenActivity.class);
                startActivity(i);
            }
        });

        dkrsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenAdminActivity.this, InsertUpdateKRSActivity.class);
                startActivity(i);
            }
        });

        dmhsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenAdminActivity.this, InsertUpdateDataDiriMHSActivity.class);
                startActivity(i);
            }
        });


    }
}