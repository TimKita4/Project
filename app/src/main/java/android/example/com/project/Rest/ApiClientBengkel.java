package android.example.com.project.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientBengkel {
    public static final String BASE_URL_BENGKEL="http://192.168.43.145/ProjectKita/index.php/Bengkel/";



    private  static Retrofit retrofit=null;
    public static Retrofit getBengkel(){
        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL_BENGKEL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
