package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.projectuas.CRUDDataDosen.LihatDataDosenActivity;
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

        ddaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenAdminActivity.this, LihatDataDosenActivity.class);
                startActivity(i);
            }
        });

        dkrsa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenAdminActivity.this, LihatKRSActivity.class);
                startActivity(i);
            }
        });

        dmhsa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenAdminActivity.this, LihatDataMHSActivity.class);
                startActivity(i);
            }
        });


    }
}
