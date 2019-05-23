package android.example.com.project;

import android.content.Intent;
import android.example.com.project.Rest.ApiClient;
import android.example.com.project.Rest.ApiInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class detail_perbaikan extends AppCompatActivity {
TextView nama,alamat,no_hp,deskripsi,jenis,kondisi;
ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_perbaikan);
        Toolbar ToolBarAtas2 = (Toolbar)findViewById(R.id.toolbar_satu);
        setSupportActionBar(ToolBarAtas2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.hitam), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        nama=findViewById(R.id.nama);
        no_hp=findViewById(R.id.no_hp);
        alamat=findViewById(R.id.alamat);
        deskripsi=findViewById(R.id.deskripsi);
        jenis=findViewById(R.id.jenis);
        kondisi=findViewById(R.id.kondisi);
        Intent mIntent=getIntent();
        nama.setText(mIntent.getStringExtra("nama"));
        no_hp.setText(mIntent.getStringExtra("no_hp"));
        alamat.setText(mIntent.getStringExtra("alamat"));
        deskripsi.setText(mIntent.getStringExtra("deskripsi"));
        jenis.setText(mIntent.getStringExtra("jenis"));
        kondisi.setText(mIntent.getStringExtra("kondisi"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }
}
