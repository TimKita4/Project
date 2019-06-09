package android.example.com.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.project.Model.Login;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Model.PostPutDelLogin;
import android.example.com.project.Rest.ApiClientLogin;
import android.example.com.project.Rest.ApiInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class login extends AppCompatActivity {
    List<Login> mLoginList;

    private EditText username, password;
    private Button btn_login;
    private TextView link_regist;
    private ProgressBar loading;
    ApiInterface mApiInterface;
    //ApiInterfaceLogin mApiInterface;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_login);
        loading = findViewById(R.id.loading);
        username = findViewById(R.id.nama);
        password = findViewById(R.id.password);
        link_regist = findViewById(R.id.link_regist);
        sharedPreferences = login.this.getSharedPreferences("remember",Context.MODE_PRIVATE);
        //cek login
        String id = sharedPreferences.getString("id","0");
        if(!id.isEmpty()){
            Intent intent= new Intent(login.this,MainActivity.class);
            startActivity(intent);
        }
        mApiInterface = ApiClientLogin.getClientLogin().create(ApiInterface.class);
        /*if (preferenceConfig.raedLoginStatus()){
            Intent intent=new Intent(login.this,MainActivity.class);
            startActivity(intent);
        }*/
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<PostPutDelLogin> postKontakCall = mApiInterface.postLogin(username.getText().toString(), password.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelLogin>() {
                    @Override
                    public void onResponse(Call<PostPutDelLogin> call, retrofit2.Response<PostPutDelLogin> response) {

                        Toast.makeText(login.this,"Berhasil Login",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(login.this,MainActivity.class);
                        intent.putExtra("nama", username.getText().toString());

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("id","1");
                        editor.commit();
                        // intent.putExtra("email",mLoginList.get(login).getEmail());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<PostPutDelLogin> call, Throwable t) {


                        Toast.makeText(login.this, "Username atau Password salah", Toast.LENGTH_LONG).show();


                    }
                });
            }
        });

    }
}
