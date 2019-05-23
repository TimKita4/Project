package android.example.com.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.project.Model.Montir;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.R;
import android.example.com.project.edit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MontirAdapter extends RecyclerView.Adapter<MontirAdapter.MyViewHolder> {
    List<Montir> mMontirList;
    Context context;

    public MontirAdapter(List <Montir> MontirList, Context context) {
        mMontirList = MontirList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.montir_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
     //   holder.mTextViewId.setText("id = " + mMontirList.get(position).getId_montir());
        holder.mTextViewNama.setText(mMontirList.get(position).getNama());
        holder.mTextViewNo.setText(mMontirList.get(position).getNo_hp());
        holder.mTextViewEmail.setText(mMontirList.get(position).getEmail());
        //holder.mTextViewFoto.setText(mMontirList.get(position).getFoto());
        final String urlGambarBerita = "http://192.168.1.16/ProjectKita/berkas/" + mMontirList.get(position).getFoto();
        // Set image ke widget dengna menggunakan Library Piccasso
        // krena imagenya dari internet
        Picasso.with(context).load(urlGambarBerita).into(holder.mTextViewFoto);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), edit.class);
                //mIntent.putExtra("id", mPerbaikanList.get(position).getId());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mMontirList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mTextViewFoto;
        public TextView mTextViewId,mTextViewNama,mTextViewNo,mTextViewEmail;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama=itemView.findViewById(R.id.tvNama);
            mTextViewNo=itemView.findViewById(R.id.tvNomor);
            mTextViewEmail=itemView.findViewById(R.id.tvEmail);
            mTextViewFoto=itemView.findViewById(R.id.tvFoto);



        }
    }
}
