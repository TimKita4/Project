package android.example.com.project.adapter;

import android.content.Intent;
import android.example.com.project.R;
import android.example.com.project.perbaikan;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;
    int[] icon = new int[]{R.drawable.perbaiki,R.drawable.part,R.drawable.montir,R.drawable.help};
    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("Cara Mengganti Oli");
        nama.setThumbnail(R.drawable.oli);
        nama.setDeskripsi("Perbaiki motor anda disini");
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("SPAREPART");
        nama.setThumbnail(R.drawable.oli);
        nama.setDeskripsi("Lihat sparepart di bengkel");
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("MONTIR KAMI");
        nama.setThumbnail(R.drawable.oli);
        nama.setDeskripsi("Daftar montir kami");
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("BANTUAN");
        nama.setThumbnail(R.drawable.oli);
        nama.setDeskripsi("Lihat petunjuk aplikasi ");
        mItems.add(nama);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
        viewHolder.des.setText(nature.getDeskripsi());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;
        public TextView des;
        public View v;


        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.status);
            des = (TextView)itemView.findViewById(R.id.deskripsi);

            imgThumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(),perbaikan.class); v.getContext().startActivity(intent);
                }
            });


        }



    }
}
