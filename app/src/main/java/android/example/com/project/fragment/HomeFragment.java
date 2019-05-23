package android.example.com.project.fragment;

import android.content.Intent;
import android.example.com.project.DataMontir;
import android.example.com.project.R;
import android.example.com.project.adapter.GridAdapter;
import android.example.com.project.perbaikan;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {
     RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    FragmentManager mFragmentManagers;
private CardView mPerbaiki,montir;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mPerbaiki=view.findViewById(R.id.perbaiki);
        mPerbaiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),perbaikan.class); v.getContext().startActivity(intent);
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

        mRecycleView= (RecyclerView)view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager=new GridLayoutManager(getActivity(),1); //jumlah grid yang digunakan 2
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter();
        mRecycleView.setAdapter(mAdapter);

        return view;

    }
}
