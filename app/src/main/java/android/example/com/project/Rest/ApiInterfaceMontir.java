package android.example.com.project.Rest;
import android.example.com.project.Model.GetMontir;
import android.example.com.project.Model.PostPutDelMontir;

import retrofit2.Call;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
public interface ApiInterfaceMontir {
    @GET("montir")
    Call<GetMontir>getMontir();

}
