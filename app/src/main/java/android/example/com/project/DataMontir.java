package android.example.com.project;

import android.content.Context;
import android.example.com.project.Model.GetMontir;
import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.Montir;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiClientMontir;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.Rest.ApiInterfaceMontir;
import android.example.com.project.adapter.MontirAdapter;
import android.example.com.project.adapter.PerbaikanAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataMontir extends AppCompatActivity {
    ApiInterfaceMontir mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DataMontir ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_montir);
        mRecyclerView = (RecyclerView) findViewById(R.id.montir);
        mLayoutManager  = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClientMontir.getMontir().create(ApiInterfaceMontir.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetMontir> perbaikanCall = mApiInterface.getMontir();
        perbaikanCall.enqueue(new Callback<GetMontir>() {
            @Override
            public void onResponse(Call<GetMontir> call, Response<GetMontir>
                    response) {
                List<Montir> MontirList = response.body().getMontirList();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(MontirList.size()));
                mAdapter =  new MontirAdapter(MontirList, DataMontir.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMontir> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}
