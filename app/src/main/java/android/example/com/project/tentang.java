package android.example.com.project;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tentang extends AppCompatActivity {
Button btn_navigasi;
String googlemap="com.google.android.apps.maps";
Uri gmmIntentUri;
Intent mapIntent;
String bengkel="-7.9171996,113.8168298";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        Toolbar ToolBarAtas2 = (Toolbar)findViewById(R.id.toolbar_satu);
        setSupportActionBar(ToolBarAtas2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.hitam), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        btn_navigasi=findViewById(R.id.btn_navigasi);
        btn_navigasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmmIntentUri=Uri.parse("google.navigation:q=" + bengkel);
                mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage(googlemap);

                if (mapIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(mapIntent);
                }else {
                    Toast.makeText(tentang.this,"Google Maps Belum Terinstal. Install Dong",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
