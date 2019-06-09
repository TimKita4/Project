package android.example.com.project.adapter;

import android.content.Intent;
import android.example.com.project.Model.Perbaikan;
import android.example.com.project.R;
import android.example.com.project.detail_perbaikan;
import android.example.com.project.edit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PerbaikanAdapter extends RecyclerView.Adapter<PerbaikanAdapter.MyViewHolder> {
    List<Perbaikan> mPerbaikanList;

    public PerbaikanAdapter(List <Perbaikan> PerbaikanList) {
        mPerbaikanList = PerbaikanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_perbaikan, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
       // holder.mTextViewId.setText("id = " + mPerbaikanList.get(position).getId());
        holder.mTextViewWaktu.setText( mPerbaikanList.get(position).getWaktu());
       // holder.mTextViewNama.setText("nama = " + mPerbaikanList.get(position).getNama());
        //holder.mTextViewNomor.setText("no_hp = " + mPerbaikanList.get(position).getNo_hp());
        //holder.mTextViewAlamat.setText("alamat = " + mPerbaikanList.get(position).getAlamat());
        holder.mTextViewJenis.setText("Perbaiki Di" + mPerbaikanList.get(position).getJenis_perbaiki());
       // holder.mTextViewDeskripsi.setText("deskripsi = " + mPerbaikanList.get(position).getDeskripsi());
        holder.mTextViewKondisi.setText( mPerbaikanList.get(position).getKondisi());
        holder.mTextViewTanggal.setText( mPerbaikanList.get(position).getTanggal());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), detail_perbaikan.class);
                //mIntent.putExtra("id", mPerbaikanList.get(position).getId());
                //mIntent.putExtra("id", mPerbaikanList.get(position).getId());
                mIntent.putExtra("nama", mPerbaikanList.get(position).getNama());
                mIntent.putExtra("no_hp", mPerbaikanList.get(position).getNo_hp());
                mIntent.putExtra("alamat", mPerbaikanList.get(position).getAlamat());
                mIntent.putExtra("deskripsi", mPerbaikanList.get(position).getDeskripsi());
                mIntent.putExtra("jenis", mPerbaikanList.get(position).getJenis_perbaiki());
                mIntent.putExtra("kondisi", mPerbaikanList.get(position).getKondisi());
                mIntent.putExtra("montir", mPerbaikanList.get(position).getMontir());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPerbaikanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewWaktu, mTextViewNama, mTextViewNomor,mTextViewAlamat,mTextViewDeskripsi,mTextViewKondisi,mTextViewTanggal,mTextViewJenis;

        public MyViewHolder(View itemView) {
            super(itemView);
            //mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewWaktu = (TextView) itemView.findViewById(R.id.tvWaktu);
           // mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            //mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
            //mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
            mTextViewJenis = (TextView) itemView.findViewById(R.id.tvJenis);
           // mTextViewDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
            mTextViewKondisi = (TextView) itemView.findViewById(R.id.tvKondisi);
            mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggal);
        }
    }
}
