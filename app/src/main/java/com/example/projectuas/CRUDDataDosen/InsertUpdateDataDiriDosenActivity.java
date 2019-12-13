package com.example.projectuas.CRUDDataDosen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import com.example.projectuas.Model.DefaultResult;
import com.example.projectuas.Network.GetDataService;
import com.example.projectuas.Network.RetrofitClientInstance;
import com.example.projectuas.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class InsertUpdateDataDiriDosenActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 58; // bebas asal nanti dipakai terus di activity yang laen, utk cek permissionnya
    private static final int PERMISSION_REQUEST_STORAGE = 58;
    private static final int GALERY_REQUEST_CODE = 58;
    private Uri uri;
    ProgressDialog progressDialog;
    private EditText nama, nidn, alamat, email, gelar, foto;
    private EditText namaDosen, nidnDosen, alamatDosen, emailDosen, gelarDosen, fotoDosen;
    private Button simpanButton, browseButton;
    private ImageView imgThumb;
    private String encodedImageData;
    private String stringImg;

    Boolean isUpdate = false;
    String idDosen;

    void checkUpdate() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        isUpdate = extras.getBoolean("is_update");
        idDosen = extras.getString("id_dosen");
        namaDosen.setText(extras.getString("nama_dosen"));
        nidnDosen.setText(extras.getString("nidn"));
        alamatDosen.setText(extras.getString("alamat"));
        emailDosen.setText(extras.getString("email"));
        gelarDosen.setText(extras.getString("gelar"));
        fotoDosen.setText(extras.getString("foto"));
        Picasso.with(this).
                load("https://kpsi.fti.ukdw.ac.id/progmob/" + extras.get("foto"))
                .into(imgThumb);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_data_diri_dosen);
        this.setTitle("SI KRS - ADMIN - CRUD Dosen");
        namaDosen = findViewById(R.id.namaETxt);
        nidnDosen = findViewById(R.id.nidnEtxt);
        alamatDosen = findViewById(R.id.alamatETxt);
        emailDosen = findViewById(R.id.emailEtxt);
        gelarDosen = findViewById(R.id.gelarETxt);
        fotoDosen = findViewById(R.id.FotoETxt2);
        imgThumb = findViewById(R.id.imgDsn);


        checkUpdate();
        simpanButton = findViewById(R.id.simpanButton);
        browseButton = findViewById(R.id.browseButton);

        //create and update data
        if (isUpdate) {
            simpanButton.setText("Update");
        }
        simpanButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if (validate()) {

                    simpanBerhasil();
                }
            }
        });


//----------------------------btn cari foto--------------------------------------------
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
    }



    public void simpanBerhasil() {
AlertDialog.Builder builder = new AlertDialog.Builder(InsertUpdateDataDiriDosenActivity.this);
                builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data tidak tersimpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!isUpdate) {
                                    progressDialog = new ProgressDialog(InsertUpdateDataDiriDosenActivity.this);
                                    progressDialog.setMessage("Mengirimkan Data");
                                    progressDialog.show();

                                    GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                    retrofit2.Call<DefaultResult> call = service.insert_dosen(

                                            idDosen,
                                            namaDosen.getText().toString(),
                                            nidnDosen.getText().toString(),
                                            alamatDosen.getText().toString(),
                                            emailDosen.getText().toString(),
                                            gelarDosen.getText().toString(),
                                            stringImg,
//                                            encodedImageData,
                                            "72170091"
                                    );
                                    call.enqueue(new Callback<DefaultResult>() {
                                        @Override
                                        public void onResponse(retrofit2.Call<DefaultResult> call, Response<DefaultResult> response) {
                                            progressDialog.dismiss();
                                            Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data tersimpan",
                                                    Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(InsertUpdateDataDiriDosenActivity.this, LihatDataDosenActivity.class);
                                            startActivity(intent);
                                        }

                                        @Override
                                        public void onFailure(retrofit2.Call<DefaultResult> call, Throwable t) {
                                            Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data TIDAK tersimpan",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    progressDialog = new ProgressDialog(InsertUpdateDataDiriDosenActivity.this);
                                    progressDialog.setMessage("Sabar ya masih nyimpan data");
                                    progressDialog.show();

                                    GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                    retrofit2.Call<DefaultResult> call = service.update_dosen(
                                            idDosen,
                                            namaDosen.getText().toString(),
                                            nidnDosen.getText().toString(),
                                            alamatDosen.getText().toString(),
                                            emailDosen.getText().toString(),
                                            gelarDosen.getText().toString(),
                                            stringImg,
//                                            encodedImageData,
                                            "72170091"
                                    );
                                    call.enqueue(new Callback<DefaultResult>() {
                                        @Override
                                        public void onResponse(retrofit2.Call<DefaultResult> call, Response<DefaultResult> response) {
                                            progressDialog.dismiss();
                                            Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data tersimpan",
                                                    Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(InsertUpdateDataDiriDosenActivity.this, LihatDataDosenActivity.class);
                                            startActivity(intent);
                                        }

                                        @Override
                                        public void onFailure(retrofit2.Call<DefaultResult> call, Throwable t) {
                                            Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data TIDAK tersimpan",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });


                AlertDialog dialog = builder.create();
                dialog.show();
    }

    public boolean validate() {
        String inputNama = namaDosen.getText().toString().trim();
        String inputNidn = nidnDosen.getText().toString().trim();
        String inputAlamat = alamatDosen.getText().toString().trim();
        String inputEmail = emailDosen.getText().toString().trim();
        String inputGelar = gelarDosen.getText().toString().trim();
        String inputFoto = fotoDosen.getText().toString().trim();
        boolean valid = true;

        if (inputNama.isEmpty()) {
            namaDosen.setError("Silahkan mengisi nama Dosen");
            valid = false;
        }

        if (inputNidn.isEmpty()) {
            nidnDosen.setError("Silahkan mengisi nidn Dosen");
            valid = false;
        }
        if (inputAlamat.isEmpty()) {
            alamatDosen.setError("Silahkan mengisi alamat Dosen");
            valid = false;
        }
        if (inputEmail.isEmpty()) {
            emailDosen.setError("Silahkan mengisi email Dosen");
            valid = false;
        }
        if (inputGelar.isEmpty()) {
            gelarDosen.setError("Silahkan mengisi gelar Dosen");
            valid = false;
        }


        return valid;
    }









        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            switch (requestCode){
                case GALERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    imgThumb.setImageURI(selectedImage);

                    //dptin real pathynya
                    String [] filePathColumn ={MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex= cursor.getColumnIndex(filePathColumn[0]);
                    String imgDecodableString = cursor.getString(columnIndex);
                    fotoDosen.setText(imgDecodableString);
                    cursor.close();

                    //conversi ke base 64
                    Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte [] b = baos.toByteArray();

                    stringImg=Base64.encodeToString(b,Base64.DEFAULT);
            }
        }
    }


    @SuppressLint("ObsoleteSdkInt")
    private String getRealPathFromURI(Uri contentURI) {

        String realPath="";
// SDK < API11
        if (Build.VERSION.SDK_INT < 11) {
            String[] proj = { MediaStore.Images.Media.DATA };
            @SuppressLint("Recycle") Cursor cursor = getContentResolver().query(uri, proj, null, null, null);
            int column_index = 0;
            String result="";
            if (cursor != null) {
                column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                realPath=cursor.getString(column_index);
            }
        }
        // SDK >= 11 && SDK < 19
        else if (Build.VERSION.SDK_INT < 19){
            String[] proj = { MediaStore.Images.Media.DATA };
            CursorLoader cursorLoader = new CursorLoader(this, uri, proj, null, null, null);
            Cursor cursor = cursorLoader.loadInBackground();
            if(cursor != null){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                realPath = cursor.getString(column_index);
            }
        }
        // SDK > 19 (Android 4.4)
        else{
            String wholeID = DocumentsContract.getDocumentId(uri);
            // Split at colon, use second item in the array
            String id = wholeID.split(":")[1];
            String[] column = { MediaStore.Images.Media.DATA };
            // where id is equal to
            String sel = MediaStore.Images.Media._ID + "=?";
            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column, sel, new String[]{ id }, null);
            int columnIndex = 0;
            if (cursor != null) {
                columnIndex = cursor.getColumnIndex(column[0]);
                if (cursor.moveToFirst()) {
                    realPath = cursor.getString(columnIndex);
                }
                cursor.close();
            }
        }
        return realPath;
    }
    //----------------------------metode untuk converd gambar--------------------------------------------
    //------------------------------klo pake metode pak argo ndak kepake ini -----------------------------
    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);

        return imgString;
    }

    //----------------------------untuk pilih gambar----------------------------------
    private void choosePhoto() {
        //----------------------------untuk permission buka galery--> bisa juga ditaruh di oncrete----------------------------------
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
               /* && ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED*/) {
            // read utk baca dari hp
            //write utk ambil dari luar

            //ini beri permmisionnya kalau blom ada
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);

        }else{
            openGallery();
        }
    }
    //----------------------------Buka galery--------------------------------------------
    public void openGallery(){


        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes={"image/jpeg"}; // filter hanya file jpeg yang ada
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        startActivityForResult(intent,GALERY_REQUEST_CODE);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_REQUEST_STORAGE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //permession granted
                }
                break;
        }
    }


//    memberikan validasi









//    private boolean validateNama(){
//        String inputNama = namaDosen.getText().toString().trim();
//        if(inputNama.isEmpty()) {
//            namaDosen.setError("Silahkan mengisi nama Dosen");
//            return false;
//        }else{
//            namaDosen.setError(null);
//            return true;
//        }
//    }

//    private boolean validateNidn(){
//        String nidnInput = nidnDosen.getText().toString().trim();
//        if(nidnInput.isEmpty()) {
//            nidnDosen.setError("Silahkan mengisi nama Dosen");
//            return false;
//        }else{
//            nidnDosen.setError(null);
//            return true;
//        }
//    }
//
//    private boolean validateAlamat(){
//        String nidnInput = alamatDosen.getText().toString().trim();
//        if(alamatInput.isEmpty()) {
//            nidnDosen.setError("Silahkan mengisi nama Dosen");
//            return false;
//        }else{
//            nidnDosen.setError(null);
//            return true;
//        }
//    }


}