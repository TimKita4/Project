package android.example.com.project.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientMontir {
    public static final String BASE_URL_MONTIIR="http://192.168.1.16/ProjectKita/index.php/Montir/";
    private  static Retrofit retrofit=null;
    public  static Retrofit getMontir(){

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL_MONTIIR)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
