package android.example.com.project.adapter;

import android.content.Intent;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.R;
import android.example.com.project.edit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PerbaikanAdapter extends RecyclerView.Adapter<PerbaikanAdapter.MyViewHolder> {
    List<Perbaikan> mPerbaikanList;

    public PerbaikanAdapter(List <Perbaikan> PerbaikanAdapter) {
        mPerbaikanList = PerbaikanAdapter;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_perbaikan, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mPerbaikanList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mPerbaikanList.get(position).getNama());
        holder.mTextViewNomor.setText("No_hp = " + mPerbaikanList.get(position).getNo_hp());
        holder.mTextViewAlamat.setText("No_hp = " + mPerbaikanList.get(position).getAlamat());
        holder.mTextViewDeskripsi.setText("No_hp = " + mPerbaikanList.get(position).getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), edit.class);
                mIntent.putExtra("Id", mPerbaikanList.get(position).getId());
                mIntent.putExtra("Nama", mPerbaikanList.get(position).getNama());
                mIntent.putExtra("No_hp", mPerbaikanList.get(position).getNo_hp());
                mIntent.putExtra("Alamat", mPerbaikanList.get(position).getAlamat());
                mIntent.putExtra("Deskripsi", mPerbaikanList.get(position).getDeskripsi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPerbaikanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor,mTextViewAlamat,mTextViewDeskripsi;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
            mTextViewDeskripsi = (TextView) itemView.findViewById(R.id.tvAlamat);
        }
    }
}
