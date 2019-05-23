package android.example.com.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
