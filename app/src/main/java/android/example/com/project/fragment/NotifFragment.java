package android.example.com.project.fragment;

import android.example.com.project.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotifFragment extends Fragment {
RecyclerView mRecycleView;
RecyclerView.LayoutManager mLayoutManager;
RecyclerView.Adapter mAdapter;
    public NotifFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_notif, container, false);
        return view;
    }
}
