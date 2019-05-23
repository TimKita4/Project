package android.example.com.project;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.example.com.project.Model.PostPutDelPerbaikan;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.Util.AppController;
import android.example.com.project.Util.ServerAPI;
import android.example.com.project.fragment.PesanFragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;


public class service extends Fragment {
    EditText edtNama,edtNomor,edtDeskripsi,edtAlamat,edtJenis;
    Button btInsert;
    TextView LatLong;
    ApiInterface mApiInterface;
    private ImageButton btPlacesAPI;
    private TextView tvPlaceAPI;
    // konstanta untuk mendeteksi hasil balikan dari place picker
    private int PLACE_PICKER_REQUEST = 1;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_service, container, false);
        edtNama = (EditText) v.findViewById(R.id.edtNama);
        edtNomor = (EditText) v.findViewById(R.id.edtNomor);
        edtAlamat=v.findViewById(R.id.edtAlamat);
        edtDeskripsi=v.findViewById(R.id.edtDeskripsi);
        LatLong=v.findViewById(R.id.latLong);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) v.findViewById(R.id.btInsert);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPerbaikan> postKontakCall = mApiInterface.postPerbaikan(edtNama.getText().toString(), edtNomor.getText().toString(), edtAlamat.getText().toString(),edtDeskripsi.getText().toString(),LatLong.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelPerbaikan>() {
                    @Override
                    public void onResponse(Call<PostPutDelPerbaikan> call, retrofit2.Response<PostPutDelPerbaikan> response) {
                        Toast.makeText(getContext(),"Berhasil",Toast.LENGTH_LONG).show();
                        PesanFragment.ma.refresh();
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPerbaikan> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        tvPlaceAPI = (TextView) v.findViewById(R.id.edtAlamat);
        LatLong = (TextView) v.findViewById(R.id.latLong);

        btPlacesAPI = (ImageButton) v.findViewById(R.id.bt_ppicker);
        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // membuat Intent untuk Place Picker
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    //menjalankan place picker
                    startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);

                    // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="http://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getActivity());
                String toastMsg = String.format(

                                "Alamat: %s \n"
                               ,  place.getAddress());
                String toastLatLong=String.format(
                                "Latlng %s \n",  place.getLatLng().latitude+" "+place.getLatLng().longitude);
                tvPlaceAPI.setText(toastMsg);
                LatLong
                        .setText(toastLatLong);
            }
        }
    }



}
