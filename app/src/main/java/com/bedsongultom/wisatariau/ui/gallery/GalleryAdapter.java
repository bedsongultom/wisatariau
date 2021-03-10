package com.bedsongultom.wisatariau.ui.gallery;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.newsupdate.News;
import com.bedsongultom.wisatariau.ui.newsupdate.NewsAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private ArrayList<Galleries> galleries;
    private Context context;



    public GalleryAdapter(Context context,ArrayList<Galleries> galleries) {
        this.galleries = galleries;
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery, viewGroup, false);

        GalleryAdapter.ViewHolder viewHolder = new GalleryAdapter.ViewHolder(v, context, galleries);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder viewHolder, int position) {

        viewHolder.image_desc.setText(galleries.get(position).getImage_desc());

        Picasso.with(context).load(galleries.get(position).getImage_url()).resize(240, 120)
                .placeholder(android.R.drawable.ic_dialog_alert)
                .error(android.R.drawable.ic_dialog_alert)
                .into(viewHolder.image_url);
    }


    @Override//jumlah data
    public int getItemCount() {
        return galleries.size();
    }
    public void editItem(int position) {
        galleries.get(position);
        notifyItemChanged(position, galleries.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image_url;
        private TextView image_desc;
        Context context;
        private Galleries currentItem;


        ViewHolder(View itemView, Context context, ArrayList<Galleries> galleries) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            image_url = (ImageView) itemView.findViewById(R.id.image_url);
            image_desc     = (TextView)itemView.findViewById(R.id.image_desc);


        }

        void bind(Galleries item) {
            image_desc.setText(String.valueOf(item.getImage_desc()));
            Picasso.with(this.context)
                    .load(""+item.getImage_url())
                    .placeholder(android.R.drawable.ic_dialog_alert)
                    .error(android.R.drawable.ic_dialog_alert)
                    .into(image_url);

            currentItem = item;

        }

       /* public ViewHolder(View view) {
            super(view);

            image_url = (ImageView) view.findViewById(R.id.image_url);
            image_desc     = (TextView)view.findViewById(R.id.image_desc);

        }*/

        @Override
        public void onClick(View v) {

        }
    }

}