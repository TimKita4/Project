package android.example.com.project;

import android.app.ProgressDialog;
import android.example.com.project.Model.ModelData;
import android.example.com.project.Tab.MyAdapter;
import android.example.com.project.Tab.SlidingTabLayout;
import android.example.com.project.Util.AppController;
import android.example.com.project.Util.ServerAPI;
import android.example.com.project.adapter.AdapterData;
import android.example.com.project.fragment.HomeFragment;
import android.example.com.project.fragment.NotifFragment;
import android.example.com.project.fragment.PesanFragment;
import android.example.com.project.fragment.ProfilFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    RecyclerView mRecycleView;
    Button btnInsert,btnDelete;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelData> mItems;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        mViewPager=(ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),this));

        mSlidingTabLayout=findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);
*/
        //-----------------Bottom navigasi--------------//

        bottomBar= findViewById(R.id.bottombar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            Fragment fragment= null;
            @Override
            public void onTabSelected(int tabId) {
                if (tabId == R.id.tab_home){
                    fragment = new HomeFragment();
                } else if (tabId == R.id.tab_pesan){
                    fragment = new PesanFragment();
                } else if (tabId == R.id.tab_notif){
                    fragment = new NotifFragment();
                } else if (tabId == R.id.tab_profil){
                    fragment = new ProfilFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
            }
        });
        pd= new ProgressDialog(MainActivity.this);
        mItems=new ArrayList<>();

//        loadJson();
    /*
        mManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecycleView.setLayoutManager(mManager);
        mAdapter=new AdapterData(MainActivity.this,mItems);
        mRecycleView.setAdapter(mAdapter);
*/

    }

    private void loadJson(){
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();
        JsonArrayRequest reqData= new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                pd.cancel();
                Log.d("volley","response" + response.toString());
                for (int i=0;i<response.length(); i++){
                    try {
                        JSONObject data=response.getJSONObject(i);
                        ModelData md=new ModelData();
                        md.setNIM(data.getString("NIM"));
                        md.setNama_mahasiswa(data.getString("Nama_mahasiswa"));
                        md.setAlamat(data.getString("Alamat"));
                        md.setJenis_kel(data.getString("Jenis_kel"));
                        mItems.add(md);

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    mAdapter.notifyDataSetChanged();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley","error" + error.getMessage());
                    }
                });
        AppController.getInstance().addToRequestQueue(reqData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
