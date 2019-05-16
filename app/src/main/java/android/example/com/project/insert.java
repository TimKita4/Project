package android.example.com.project;

import android.example.com.project.Model.PostPutDelPerbaikan;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class insert extends AppCompatActivity {

    EditText edtNama, edtNomor,edtAlamat,edtDeskripsi;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNomor = (EditText) findViewById(R.id.edtNomor);
        edtAlamat=findViewById(R.id.edtAlamat);
        edtDeskripsi=findViewById(R.id.edtDeskripsi);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPerbaikan> postKontakCall = mApiInterface.postPerbaikan(edtNama.getText().toString(), edtNomor.getText().toString(), edtAlamat.getText().toString(),edtDeskripsi.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelPerbaikan>() {
                    @Override
                    public void onResponse(Call<PostPutDelPerbaikan> call, Response<PostPutDelPerbaikan> response) {
                        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();
                        Main2Activity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPerbaikan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.ma.refresh();
                finish();
            }
        });
    }
}
