package android.example.com.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class serviceJalan extends Fragment {


    public serviceJalan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_service_bengkel, container, false);
        return view;
    }
}
