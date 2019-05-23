package android.example.com.project;

import android.content.Intent;
import android.example.com.project.Model.PostPutDelLogin;
import android.example.com.project.Model.PostPutDelPerbaikan;
import android.example.com.project.Rest.ApiInterface;
import android.example.com.project.Rest.ApiInterfaceLogin;
import android.example.com.project.fragment.PesanFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class login extends AppCompatActivity {

    private EditText username, password;
    private Button btn_login;
    private TextView link_regist;
    private ProgressBar loading;
    ApiInterfaceLogin mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_login);
        loading = findViewById(R.id.loading);
        username = findViewById(R.id.nama);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        link_regist = findViewById(R.id.link_regist);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Call<PostPutDelLogin> postKontakCall = mApiInterface.postLogin(username.getText().toString(), password.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelLogin>() {
                    @Override
                    public void onResponse(Call<PostPutDelLogin> call, retrofit2.Response<PostPutDelLogin> response) {
                        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelLogin> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }
}
