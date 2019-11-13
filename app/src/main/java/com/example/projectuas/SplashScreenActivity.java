package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading = 4000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        SharedPreferences prefs = SplashScreenActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin=prefs.getString("isLogin",null);
        if(statusLogin!=null){
            if(statusLogin.equals("Admin")){
                Intent intent = new Intent(SplashScreenActivity.this, HomeScreenAdminActivity.class);
                startActivity(intent);
            }else if(statusLogin.equals("Mhs")){
                Intent intent = new Intent(SplashScreenActivity.this,HomeScreenDsnActivity.class);
                startActivity(intent);
            }
        }
        else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), LoginScreenActivity.class));
                    finish();
                }
            }, 3000L);
        }
    }
}