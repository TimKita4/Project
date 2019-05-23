package android.example.com.project.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientLogin {
    public static final String BASE_URL_LOGIN="http://192.168.1.16/ProjectKita/index.php/Login/";

    private  static Retrofit retrofit=null;
    public static Retrofit getLogin(){
        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL_LOGIN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
