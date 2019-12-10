package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        email = (EditText) findViewById(R.id.txtEmail);
        pass = (EditText) findViewById(R.id.txtPass);
        login = (Button) findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            SharedPreferences prefs = LoginScreenActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin",null);
            SharedPreferences.Editor edit = prefs.edit();
            @Override
            public void onClick(View view) {
                String emaail = email.getText().toString();
                String password = pass.getText().toString();
                if (emaail.contains("@si.ukdw.ac.id")) {
                    edit.putString("isLogin", "Mhs");
                    edit.commit();
                    Intent i = new Intent(LoginScreenActivity.this, HomeScreenAdminActivity.class);
                    startActivity(i);


                } else if (emaail.contains("@staff.ac.id")) {
                    edit.putString("isLogin", "Admin");
                    edit.commit();
                    Intent i = new Intent(LoginScreenActivity.this, HomeScreenDsnActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(LoginScreenActivity.this, "error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
