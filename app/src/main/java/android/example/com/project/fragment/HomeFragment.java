package android.example.com.project.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.project.DataMontir;
import android.example.com.project.MainActivity;
import android.example.com.project.Model.GetPerbaikan;
import android.example.com.project.Model.GetSparepart;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Model.Sparepart;
import android.example.com.project.R;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiClientSparepart;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.adapter.PerbaikanAdapter;
import android.example.com.project.adapter.SparepartAdapter;
import android.example.com.project.perbaikan;
import android.example.com.project.tentang;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    TextView username;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HomeFragment ma;
private CardView mPerbaiki,montir,vTentang;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView fPerbaiki=view.findViewById(R.id.fPerbaiki);
        Typeface customfont=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        fPerbaiki.setTypeface(customfont);
        TextView fSparepart=view.findViewById(R.id.fSparepart);
        Typeface customfont2=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        fSparepart.setTypeface(customfont2);
        TextView fMontir=view.findViewById(R.id.fMontir);
        Typeface customfont3=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        fMontir.setTypeface(customfont3);
        TextView fTentang=view.findViewById(R.id.fTentang);
        Typeface customfont4=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        fTentang.setTypeface(customfont4);
        TextView fPart=view.findViewById(R.id.part);
        Typeface customfont5=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        fPart.setTypeface(customfont5);

        mPerbaiki=view.findViewById(R.id.perbaiki);
        mPerbaiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),perbaikan.class); v.getContext().startActivity(intent);
            }
        });
        vTentang=(CardView)view.findViewById(R.id.tentang);
        vTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),tentang.class);
                v.getContext().startActivity(intent);
            }
        });
        montir=view.findViewById(R.id.montir);
        montir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DataMontir.class);
                v.getContext().startActivity(intent);
            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("remember",Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id","0");

        username=view.findViewById(R.id.username);
        username.setText(getActivity().getIntent().getStringExtra("id"));
        mRecyclerView = (RecyclerView) view.findViewById(R.id.sparepartView);
        mLayoutManager  = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClientSparepart.getSparepart().create(ApiInterface.class);
        ma=this;
        refresh();
        return view;

    }

    public void refresh() {
        Call<GetSparepart> perbaikanCall = mApiInterface.getSparepart();
        perbaikanCall.enqueue(new Callback<GetSparepart>() {
            @Override
            public void onResponse(Call<GetSparepart> call, Response<GetSparepart>
                    response) {
                List<Sparepart> SparepartList = response.body().getSparepartList();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(SparepartList.size()));
                mAdapter = new SparepartAdapter(SparepartList,getActivity());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetSparepart> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
