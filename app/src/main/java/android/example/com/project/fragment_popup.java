package android.example.com.project;

import android.example.com.project.Model.GetBengkel;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Rest.ApiClientBengkel;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.adapter.PerbaikanAdapter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_popup extends DialogFragment {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static fragment_popup ma;
    public fragment_popup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_popup, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClientBengkel.getBengkel().create(ApiInterface.class);
        ma = this;
        refresh();
        return view;
    }
    public void refresh() {
        Call<GetBengkel> perbaikanCall = mApiInterface.getBengkel();
        perbaikanCall.enqueue(new Callback<GetBengkel>() {
            @Override
            public void onResponse(Call<GetBengkel> call, Response<GetBengkel>
                    response) {
                List<Perbaikan> PerbaikanList = response.body().getPerbaikanList();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(PerbaikanList.size()));
                mAdapter = new PerbaikanAdapter(PerbaikanList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetBengkel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


}
