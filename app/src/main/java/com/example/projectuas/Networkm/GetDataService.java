package com.example.projectuas.Networkm;

import com.example.projectuas.Model.MMahasiswaActivity;

import java.util.ArrayList;
import java.util.List;

import com.example.projectuas.Model.DefaultResult;
import  com.example.projectuas.Model.MMahasiswaActivity;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/api/progmob/mhs/{nim_progmob}")
    Call<ArrayList<MMahasiswaActivity>> getMhsAll(@Path("nim_progmob") String nim_progmob);


    @FormUrlEncoded
    @POST("/api/progmob/mhs/createfoto")
    Call<DefaultResult> insert_mhs(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("nim") String nidn,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("/api/progmob/mhs/updatewithfoto")
    Call<DefaultResult> update_mhs(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );


    @FormUrlEncoded
    @POST("/api/progmob/mhs/delete")
    Call<DefaultResult> delete_mhs(
            @Field("id") String id,
            @Field("nim_progmob") String nim_progmob
    );

    /*@FormUrlEncoded
    @POST("/si_mapping/api/user_login.php")
    Call<UserLogin> getUserLogin(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/si_mapping/api/insert_one_titik_lahan.php")
    Call<DefaultResult> insert_one_titik_lahan(
            @Field("id_lahan") String id_lahan,
            @Field("id_detil") String id_detil,
            @Field("lat") String lat,
            @Field("longt") String longt
    );
    @FormUrlEncoded
    @POST("/si_mapping/api/insert_petani_urgent.php")
    Call<DefaultResult> insert_petani_urgent(
            @Field("ID_User") String id_user,
            @Field("nama_petani") String nama_petani
    );
    @FormUrlEncoded
    @POST("/si_mapping/api/insert_one_titik_lahan.php")
    Call<List<DetilTitikLahan>> insert_one_titik_lahanv2(
            @Field("id_lahan") String id_lahan,
            @Field("id_detil") String id_detil,
            @Field("lat") String lat,
            @Field("longt") String longt
    );
    @FormUrlEncoded
    @POST("/si_mapping/api/insert_lahan.php")
    Call<DefaultResult> insert_lahan(
            @Field("nama_petani") String nama_petani,
            @Field("nama_lahan") String nama_lahan,
            @Field("luas_lahan") String luas_lahan,
            @Field("jenis_lahan") String jenis_lahan,
            @Field("provinsi") String provinsi,
            @Field("Kabupaten") String kabupaten,
            @Field("Kecamatan") String kecamatan,
            @Field("Desa_Kelurahan") String desa_kelurahan,
            @Field("status_organik") String status_organik,
            @Field("status_lahan") String status_lahan,
            @Field("ID_User") String id_user,
            @Field("lat") String lat,
            @Field("longt") String longt
    );
    @GET("/si_mapping/api/read_petani.php")
    Call<List<LahanPetani>> getLahanPetaniAll(@Query("nama_petani") String nama_petani);
    @GET("/si_mapping/api/read_lahan_one_petani_simple.php")
    Call<List<LahanOnePetani>> getLahanOnePetaniSimple(@Query("id_user") String id_user);
    @GET("/si_mapping/api/read_one_detail_lahan.php")
    Call<List<DetilTitikLahan>> getDetilTitikLahan(@Query("id_lahan") String id_lahan);
    *//*@GET("/1.1/statuses/user_timeline.json?screen_name=BPPTKG&count=10")
    Call<List<UserLogin>> getAllTwitFromBpptkg();*/
}
