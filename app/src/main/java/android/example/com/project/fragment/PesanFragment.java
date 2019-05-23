package android.example.com.project.fragment;

import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.R;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.adapter.PerbaikanAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PesanFragment extends Fragment {
    Button btn_inst;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static PesanFragment ma;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pesan, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.ayolah);
        mLayoutManager  = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

        return rootView;
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
