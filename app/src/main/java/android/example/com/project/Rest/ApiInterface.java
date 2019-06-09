package android.example.com.project.Rest;

import android.example.com.project.Model.GetBengkel;
import android.example.com.project.Model.GetMontir;
import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.GetSparepart;
import android.example.com.project.Model.PostPutDelBengkel;
import android.example.com.project.Model.PostPutDelLogin;
import android.example.com.project.Model.PostPutDelPerbaikan;
import retrofit2.Call;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface ApiInterface {
    @GET("perbaikan")
    Call<GetPerbaikan> getPerbaikan();
    @GET("perbaikan")
    Call<GetBengkel> getBengkel();
    @GET("montir")
    Call<GetMontir>getMontir();

    @GET("sparepart")
    Call<GetSparepart>getSparepart();
    @FormUrlEncoded
    @POST("perbaikan")
    Call<PostPutDelPerbaikan> postPerbaikan(@Field("nama") String nama,
                                            @Field("no_hp") String no_hp,
                                            @Field("alamat") String alamat,
                                            @Field("deskripsi") String deskripsi,
                                            @Field("LatLong") String LatLong
                                            );
    @FormUrlEncoded
    @POST("perbaikan")
    Call<PostPutDelBengkel> postBengkel(@Field("nama") String nama,
                                            @Field("no_hp") String no_hp,
                                            @Field("deskripsi") String deskripsi

    );

    @FormUrlEncoded
    @POST("perbaikan")
    Call<PostPutDelLogin> postLogin(@Field("username") String nama,
                                    @Field("password") String no_hp

    );

    @FormUrlEncoded
    @PUT("perbaikan")
    Call<PostPutDelPerbaikan> putPerbaikan(@Field("id") String id,
                                        @Field("nama") String nama,
                                        @Field("alamat") String alamat,
                                        @Field("deskripsi") String deskripsi,
                                        @Field("no_hp") String no_hp);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "perbaikan", hasBody = true)
    Call<PostPutDelPerbaikan> deletePerbaikan(@Field("id") String id);
}
