package com.bedsongultom.wisatariau.ui.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.gallery.Galleries;
import com.bedsongultom.wisatariau.ui.gallery.GalleryAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private ArrayList<Videos> videos;
    private Context context;


    public VideoAdapter(Context context,ArrayList<Videos> videosArrayList) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);
        return new VideoAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder viewHolder, int position) {

        viewHolder.title.setText(videos.get(position).getTitle());

        Picasso.with(context).load(videos.get(position).getImageUrl()).resize(240, 120)
                .placeholder(android.R.drawable.ic_dialog_alert)
                .error(android.R.drawable.ic_dialog_alert)
                .into(viewHolder.imageUrl);

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageUrl;
        private TextView title;


        public ViewHolder(View view) {
            super(view);

            imageUrl = (ImageView) view.findViewById(R.id.imageUrl);
            title = (TextView)view.findViewById(R.id.title);


        }
    }
}
