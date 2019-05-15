package android.example.com.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.project.Model.ModelData;
import android.example.com.project.R;
import android.example.com.project.service;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ModelData> mItems;
    private Context context;
    public AdapterData(Context context, List<ModelData> items){
        this.mItems=items;
        this.context=context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder( ViewGroup parent, int viewType) {
        View layout=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        HolderData holderData= new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder( HolderData holder, int position) {
        ModelData md=mItems.get(position);
        holder.Nama_mahasiswa.setText(md.getNama_mahasiswa());
        holder.NIM.setText(md.getNIM());
        holder.Alamat.setText(md.getAlamat());
        holder.Jenis_kel.setText(md.getJenis_kel());

        holder.md=md;

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder
    {
        TextView  NIM,Nama_mahasiswa,Alamat,Jenis_kel;
        ModelData md;
        public HolderData(View view){
            super(view);
            Nama_mahasiswa=(TextView)view.findViewById(R.id.Nama_mahasiswa);
            NIM=(TextView) view.findViewById(R.id.NIM);
            Alamat=(TextView) view.findViewById(R.id.Alamat);
            Jenis_kel=(TextView) view.findViewById(R.id.Jenis_kel);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent update= new Intent(context, service.class);
                    update.putExtra("update",1);
                    update.putExtra("nim",md.getNIM());
                    update.putExtra("nama",md.getNama_mahasiswa());
                    update.putExtra("alamat",md.getAlamat());
                    update.putExtra("jenis_kel",md.getJenis_kel());

                    context.startActivity(update);
                }
            });

        }
    }
}
