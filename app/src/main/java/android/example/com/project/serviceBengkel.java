package android.example.com.project;

import android.app.Dialog;
import android.content.Intent;
import android.example.com.project.Model.PostPutDelBengkel;
import android.example.com.project.Rest.ApiClientBengkel;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.fragment.PesanFragment;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;


public class serviceBengkel extends Fragment {
    Dialog myDialog;
    EditText edtnama,edtno_hp, edtdeskripsi;
    ApiInterface mApiInterface;
    String googlemap="com.google.android.apps.maps";
    Uri gmmIntentUri;
    Intent mapIntent;
    String bengkel="-7.9171996,113.8168298";
    Button perbaiki,btInsert,btnLokasi;
    public serviceBengkel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_service_bengkel, container, false);
       /**/
        TextView judul=v.findViewById(R.id.judul);
        Typeface customfont=Typeface.createFromAsset(getContext().getAssets(),"font/NeoSansTR.otf");
        judul.setTypeface(customfont);
        edtnama=(EditText) v.findViewById(R.id.nama);
        edtno_hp=(EditText) v.findViewById(R.id.no_hp);
        edtdeskripsi=(EditText) v.findViewById(R.id.deskripsi);
        mApiInterface = ApiClientBengkel.getBengkel().create(ApiInterface.class);
        btInsert = (Button) v.findViewById(R.id.btnInsert);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelBengkel> postKontakCall = mApiInterface.postBengkel(edtnama.getText().toString(), edtdeskripsi.getText().toString(), edtno_hp.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelBengkel>() {
                    @Override
                    public void onResponse(Call<PostPutDelBengkel> call, retrofit2.Response<PostPutDelBengkel> response) {
                        Toast.makeText(getContext(),"Berhasil",Toast.LENGTH_LONG).show();
                        //PesanFragment.ma.refresh();
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelBengkel> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        perbaiki= v.findViewById(R.id.bPerbaiki);
       perbaiki.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               fragment_popup popup=new fragment_popup();
               popup.show(getFragmentManager(),"fragment_popup");
           }
       });

        btnLokasi=v.findViewById(R.id.btn_navigasi);
        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmmIntentUri=Uri.parse("google.navigation:q=" + bengkel);
                mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage(googlemap);
                startActivity(mapIntent);
            }
        });

        return v;
    }


}
