package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.CRUDDataDosen.InsertUpdateDataDiriDosenActivity;
import com.example.projectuas.CRUDDataDosen.LihatDataDosenActivity;
import com.example.projectuas.CRUDKRS.InsertUpdateKRSActivity;
import com.example.projectuas.CRUDKRS.LihatKRSActivity;
import com.example.projectuas.CRUDMatkul.InsertUpdateMatkulActivity;
import com.example.projectuas.CRUDMatkul.LihatMatkulActivity;

public class HomeScreenDsnActivity extends AppCompatActivity {
ImageButton ddBtn;
ImageButton dkrsBtn;
ImageButton dklsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_dsn);

        ImageButton ddBtn = (ImageButton) findViewById(R.id.ddBtn);
        ImageButton dkrsBtn = (ImageButton) findViewById(R.id.dkrsBtn);
        ImageButton dklsBtn = (ImageButton) findViewById(R.id.dklsBtn);

        ddBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenDsnActivity.this, InsertUpdateDataDiriDosenActivity.class);
                startActivity(i);
            }
        });

        dkrsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenDsnActivity.this, InsertUpdateKRSActivity.class);
                startActivity(i);
            }
        });
        dklsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeScreenDsnActivity.this, InsertUpdateMatkulActivity.class);
                startActivity(i);
            }
        });

    }
};