package android.example.com.project;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class service extends Fragment {
    EditText nama,no_hp,deskripsi,kel;
    Button tambah, batal;
    private ProgressBar loading;
    ProgressDialog pd;
    private FragmentTabHost mTabhost;
    private static final String URL_REGIST="http://192.168.1.16/android_register_login/register.php";
    public service() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_service, container, false);
        nama=view.findViewById(R.id.nama);
        no_hp=view.findViewById(R.id.no_hp);
        deskripsi=view.findViewById(R.id.deskripsi);
        kel=view.findViewById(R.id.kel);
        tambah=view.findViewById(R.id.tambah);
        //batal=view.findViewById(R.id.batal);


        return view;

    }



}
