package com.example.projectuas;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading = 4000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(MainActivity.this, LoginScreenActivity.class);
                startActivity(home);
                finish();

            }
        }, waktu_loading);


    }

}