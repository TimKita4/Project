package android.example.com.project;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.example.com.project.Model.ModelData;
import android.example.com.project.Tab.SlidingTabLayout;
import android.example.com.project.fragment.HomeFragment;
import android.example.com.project.fragment.NotifFragment;
import android.example.com.project.fragment.PesanFragment;
import android.example.com.project.fragment.ProfilFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

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
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("remember",Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id","0");


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
