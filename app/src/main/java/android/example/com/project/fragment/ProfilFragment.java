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
        mTabhost=(FragmentTabHost)view.findViewById(android.R.id.tabhost );
        mTabhost.setup(getActivity(),getChildFragmentManager(),R.id.realtabcontent);
        mTabhost.addTab(mTabhost.newTabSpec("post").setIndicator("Post"),serviceBengkel.class,null);
        mTabhost.addTab(mTabhost.newTabSpec("search").setIndicator("Search"),PesanFragment.class,null);
        return view;
    }
}
