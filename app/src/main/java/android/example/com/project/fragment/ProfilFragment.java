package android.example.com.project.fragment;

import android.example.com.project.R;
import android.example.com.project.serviceBengkel;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfilFragment extends Fragment {
    private FragmentTabHost mTabhost;
    public ProfilFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profil, container, false);
        return view;
    }
}
