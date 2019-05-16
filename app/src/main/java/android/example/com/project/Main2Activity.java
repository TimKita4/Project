package android.example.com.project;

import android.content.Intent;
import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.adapter.PerbaikanAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    Button btn_inst;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Main2Activity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_inst=findViewById(R.id.btIns);
        btn_inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,insert.class);
                startActivity(intent);
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
    }
    public void refresh() {
        Call<GetPerbaikan> perbaikanCall = mApiInterface.getPerbaikan();
        perbaikanCall.enqueue(new Callback<GetPerbaikan>() {
            @Override
            public void onResponse(Call<GetPerbaikan> call, Response<GetPerbaikan>
                    response) {
                List<Perbaikan> PerbaikanList = response.body().getPerbaikanList();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(PerbaikanList.size()));
                mAdapter = new PerbaikanAdapter(PerbaikanList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPerbaikan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
