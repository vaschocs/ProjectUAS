package com.example.projectuas.CRUDMatkul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectuas.CRUDMatkul.LihatMatkulActivity;
import com.example.projectuas.R;

public class InsertUpdateMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_matkul);
        Button simpanButton = findViewById(R.id.simpanButton);


        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InsertUpdateMatkulActivity.this, LihatMatkulActivity.class);
                startActivity(intent);
            }
        });

    }
}
