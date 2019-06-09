package android.example.com.project.adapter;

import android.content.Intent;
import android.example.com.project.Model.Login;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.R;
import android.example.com.project.detail_perbaikan;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.MyViewHolder> {
    List<Login> mLoginList;

    public LoginAdapter(List <Login> LoginList) {
        mLoginList = LoginList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_perbaikan, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewUsername.setText( mLoginList.get(position).getUsername());
        holder.mTextViewEmail.setText( mLoginList.get(position).getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), detail_perbaikan.class);
                //mIntent.putExtra("id", mPerbaikanList.get(position).getId());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mLoginList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewUsername, mTextViewEmail;

        public MyViewHolder(View itemView) {
            super(itemView);
            //mTextViewKondisi = (TextView) itemView.findViewById(R.id.tvKondisi);
            //mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggal);
        }
    }
}
