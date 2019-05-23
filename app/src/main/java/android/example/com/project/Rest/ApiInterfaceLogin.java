package android.example.com.project.Rest;

import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.PostPutDelLogin;
import android.example.com.project.Model.PostPutDelPerbaikan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterfaceLogin {
    @GET("login")
    Call<GetPerbaikan> getLogin();
    @FormUrlEncoded
    @POST("login")
    Call<PostPutDelLogin> postLogin(@Field("username") String username,
                                    @Field("password") String password);
}
