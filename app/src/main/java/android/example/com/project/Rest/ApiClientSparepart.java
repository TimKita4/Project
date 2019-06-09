package android.example.com.project.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientSparepart {
    public static final String BASE_URL_SPAREPART="http://192.168.43.145/ProjectKita/index.php/Sparepart/";


    private static Retrofit retrofit=null;
    public static Retrofit getSparepart(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_SPAREPART)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
        }

    }
