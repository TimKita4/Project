package android.example.com.project.Tab;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */


import android.content.Context;
import android.example.com.project.R;
import android.example.com.project.service;
import android.example.com.project.serviceJalan;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;


/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"A","B"};
    int[] icon = new int[]{R.drawable.bengkel,R.drawable.maps};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment= null;

        if(position ==0){
            fragment = new service();
        }else if(position == 1){
            fragment = new serviceJalan();}

        Bundle b = new Bundle();
        b.putInt("position", position);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}