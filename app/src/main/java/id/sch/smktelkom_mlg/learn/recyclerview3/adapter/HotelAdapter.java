package id.sch.smktelkom_mlg.learn.recyclerview3.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.recyclerview3.R;
import id.sch.smktelkom_mlg.learn.recyclerview3.model.Hotel;

/**
 * Created by Dafa Zakhulhaq on 02/11/2016.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    ArrayList<Hotel> hotellist;
    IHotelAdapter mIHotelAdapter;


    public HotelAdapter(Context context, ArrayList<Hotel> hotellist) {

        this.hotellist = hotellist;
        mIHotelAdapter = (IHotelAdapter) context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Hotel hotel = hotellist.get(position);
        holder.tvjudul.setText(hotel.judul);
        holder.tvdeskripsi.setText(hotel.deskripsi);
        holder.ivfoto.setImageURI(Uri.parse(hotel.foto));

    }

    @Override
    public int getItemCount() {

        if (hotellist != null) {
            return hotellist.size();
        }
        return 0;
    }

    public interface IHotelAdapter {

        void doClick(int pos);

        void doEdit(int pos);

        void doDelete(int pos);

        void doFav(int pos);

        void doShare(int pos);


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivfoto;
        TextView tvjudul;
        TextView tvdeskripsi;
        Button bEdit;
        Button bDelete;
        ImageButton ibFav;
        ImageButton ibShare;


        public ViewHolder(View itemView) {
            super(itemView);

            ivfoto = (ImageView) itemView.findViewById(R.id.imageview);
            tvjudul = (TextView) itemView.findViewById(R.id.textviewjudul);
            tvdeskripsi = (TextView) itemView.findViewById(R.id.textviewdeskripsi);
            bEdit = (Button) itemView.findViewById(R.id.buttonedit);
            bDelete = (Button) itemView.findViewById(R.id.buttondelete);
            ibFav = (ImageButton) itemView.findViewById(R.id.buttonfavorite);
            ibShare = (ImageButton) itemView.findViewById(R.id.buttonshare);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mIHotelAdapter.doClick(getAdapterPosition());

                }
            });

            bEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doEdit(getAdapterPosition());
                }
            });

            bDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doDelete(getAdapterPosition());
                }
            });


            ibFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doFav(getAdapterPosition());
                }
            });

            ibShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doShare(getAdapterPosition());
                }
            });


        }

    }
}
