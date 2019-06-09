package android.example.com.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.Model.Sparepart;
import android.example.com.project.R;
import android.example.com.project.detail_perbaikan;
import android.example.com.project.edit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class SparepartAdapter extends RecyclerView.Adapter<SparepartAdapter.MyViewHolder> {
    List<Sparepart> mSparepartList;
    Context context;

    public SparepartAdapter(List <Sparepart> SparepartList,Context context) {
        mSparepartList = SparepartList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sparepart_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewNama.setText( mSparepartList.get(position).getNama());
        holder.mTextViewHarga.setText( mSparepartList.get(position).getHarga());
        holder.mTextViewStok.setText( mSparepartList.get(position).getStok());
        final String urlGambarBerita = "http://192.168.43.145/ProjectKita/berkas/" + mSparepartList.get(position).getFoto();
        Picasso.with(context).load(urlGambarBerita).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), detail_perbaikan.class);
                mIntent.putExtra("nama", mSparepartList.get(position).getNama());
                mIntent.putExtra("harga", mSparepartList.get(position).getHarga());
                mIntent.putExtra("stok", mSparepartList.get(position).getStok());
                mIntent.putExtra("foto", mSparepartList.get(position).getFoto());
                mIntent.putExtra("deskripsi", mSparepartList.get(position).getDeskripsi());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mSparepartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewHarga, mTextViewNama, mTextViewStok,mTextViewDeskripsi;
        public ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.tvFoto);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewHarga=(TextView) itemView.findViewById(R.id.tvHarga);
            mTextViewStok = (TextView) itemView.findViewById(R.id.tvStok);
        }
    }
}
