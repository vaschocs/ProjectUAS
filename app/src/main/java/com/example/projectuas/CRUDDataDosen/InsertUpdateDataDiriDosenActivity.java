package com.example.projectuas.CRUDDataDosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectuas.HomeScreenDsnActivity;
import com.example.projectuas.Model.DefaultResult;
import com.example.projectuas.Network.GetDataService;
import com.example.projectuas.Network.RetrofitClientInstance;
import com.example.projectuas.R;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class InsertUpdateDataDiriDosenActivity extends AppCompatActivity {
    ProgressDialog pd;
    EditText nidn, nama, gelar, alamat, email, foto;
    GetDataService service;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private ImageView imgDsn;
    private ProgressDialog progressDialog;
    private static final int GALLERY_REQUEST_CODE = 100;
    private static final int FIlE_ACCESS_REQUEST_CODE = 100;
    private String stringImg = "";
    private boolean isUpdate = false;
    private String idDsn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update_data_diri_dosen);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, FIlE_ACCESS_REQUEST_CODE);
        }


//        idDsn = (EditText) findViewById(R.id.id)
        nama = (EditText) findViewById(R.id.namaETxt);
        nidn = (EditText) findViewById(R.id.nidnEtxt);
        alamat = (EditText) findViewById(R.id.alamatETxt);
        email = (EditText) findViewById(R.id.emailEtxt);
        gelar = (EditText) findViewById(R.id.gelarETxt);
        foto = (EditText) findViewById(R.id.FotoETxt2);
        imgDsn = (ImageView)findViewById(R.id.imgDsn);


        this.setTitle("SI KRS - Hai Dosen");

        pd = new ProgressDialog(this);

        checkUpdate();

        Button simpanButton = findViewById(R.id.simpanButton);
        if (isUpdate) {
            simpanButton.setText("Update");
        }

        Button btnBrowse = findViewById(R.id.btnBrowse);

//
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                String[] mimeTypes = {"image/jpeg"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });


        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(InsertUpdateDataDiriDosenActivity.this);
                builder.setMessage("Apakah anda ingin menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(InsertUpdateDataDiriDosenActivity.this, HomeScreenDsnActivity.class);
                                startActivity(i);
                                Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Tidak jadi Save",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                pd.setMessage("send data");
                                pd.setCancelable(false);
                                pd.show();


//                                String snidn = nidn.getText().toString();
//                                String snama = nama.getText().toString();
//                                String salamat = alamat.getText().toString();
//                                String semail = email.getText().toString();
//                                String sgelar = gelar.getText().toString();


                                service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                Call<DefaultResult> call = service.insert_dosen(idDsn,nama.getText().toString(),
                                        nidn.getText().toString(), alamat.getText().toString(),
                                        email.getText().toString(), gelar.getText().toString(), "https://source.unsplash.com/random", "72170091");
                                call.enqueue(new Callback<DefaultResult>() {
                                    @Override
                                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                        pd.dismiss();
                                        Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "Data tersimpan",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(InsertUpdateDataDiriDosenActivity.this, LihatDataDosenActivity.class);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                                        Toast.makeText(InsertUpdateDataDiriDosenActivity.this, "GAGALLLLL",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });

//                                Intent i = new Intent(EditDosenActivity.this, CRUDDosenActivity.class);
//                                startActivity(i);
//
//                                Toast.makeText(EditDosenActivity.this, "Save Berhasil !!",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }


    void checkUpdate() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        isUpdate = extras.getBoolean("isUpdate");
        idDsn = extras.getString("id_dosen");
        nama.setText(extras.getString("nama_dosen"));
        nidn.setText(extras.getString("nidn_dosen"));
        alamat.setText(extras.getString("alamat_dosen"));
        email.setText(extras.getString("email_dosen"));
        gelar.setText(extras.getString("gelar_dosen"));
        foto.setText(extras.getString("foto_dosen"));
        stringImg = extras.getString("foto");
        Picasso.with(InsertUpdateDataDiriDosenActivity.this)
                .load("https://kpsi.fti.ukdw.ac.id/progmob/" + extras.getString("foto"))
                .into(imgDsn);

    }

//    private void openGallery(){
//        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(gallery, PICK_IMAGE);
//    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case FIlE_ACCESS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {

                }
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    imgDsn.setImageURI(selectedImage);


                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);

                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

                    String imgDecodableString = cursor.getString(columnIndex);
                    foto.setText(imgDecodableString);
                    cursor.close();


                    Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte [] b = baos.toByteArray();

                    stringImg=Base64.encodeToString(b,Base64.DEFAULT);
                    break;
            }
    }
}
