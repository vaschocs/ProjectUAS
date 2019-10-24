package com.example.projectuas.CRUDDataMahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectuas.R;

public class InsertUpdateDataDiriMHSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_data_diri_dosen);
        Button simpanButton = findViewById(R.id.simpanButton);
        Button browseButton = findViewById(R.id.browseButton);

        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InsertUpdateDataDiriMHSActivity.this,LihatDataMHSActivity.class);
                startActivity(intent);
            }
        });

    }
}
