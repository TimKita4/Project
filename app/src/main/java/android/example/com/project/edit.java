package android.example.com.project;

import android.content.Intent;
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

public class edit extends AppCompatActivity {

    EditText edtId, edtNama, edtNomor,edtAlamat,edtDeskripsi;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNomor = (EditText) findViewById(R.id.edtNomor);
        edtDeskripsi = (EditText) findViewById(R.id.edtDeskripsi);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNomor.setText(mIntent.getStringExtra("Nomor"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPerbaikan> updateKontakCall = mApiInterface.putPerbaikan(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtAlamat.getText().toString(),
                        edtDeskripsi.getText().toString(),
                        edtNomor.getText().toString());
                updateKontakCall.enqueue(new Callback<PostPutDelPerbaikan>() {
                    @Override
                    public void onResponse(Call<PostPutDelPerbaikan> call, Response<PostPutDelPerbaikan> response) {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelPerbaikan> deleteKontak = mApiInterface.deletePerbaikan(edtId.getText().toString());
                    deleteKontak.enqueue(new Callback<PostPutDelPerbaikan>() {
                        @Override
                        public void onResponse(Call<PostPutDelPerbaikan> call, Response<PostPutDelPerbaikan> response) {
                            Main2Activity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelPerbaikan> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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
