package com.bedsongultom.wisatariau.ui.newsupdate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bedsongultom.wisatariau.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        ArrayList<News> all_berita = new ArrayList<News>();
        Context context;
        final String TAG_TO_FRAGMENT = "NewsDetailFragment";

    public NewsAdapter(Context context, ArrayList<News> all_berita) {
        this.context = context;
        this.all_berita = all_berita;
    }


   /* public BooksAdapter(Context applicationContext, List<Books> booksList) {
        this.booksList = this.booksList;
        this.context = context;
    }*/


        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_newsupdate, parent, false);

            NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(v, context, all_berita);
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(final NewsAdapter.ViewHolder holder, final int position) {
            News item = all_berita.get(position);


            holder.bind(item);
        }


        @Override
        public int getItemCount() {
            //     return (booksList != null) ? 0 : booksList.size();
            return all_berita.size();
        }

        public void editItem(int position) {
            all_berita.get(position);
            notifyItemChanged(position, all_berita.size());
        }


        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            ImageView poster;
            TextView judul, tipe, link, waktu;

            private News currentItem;
            Context context;

            ViewHolder(View itemView, Context context, List<News> menuList) {
                super(itemView);
                itemView.setOnClickListener(this);
                this.context = context;
                poster  = (ImageView) itemView.findViewById(R.id.img_poster);
                judul   = (TextView) itemView.findViewById(R.id.judul);
                link    = (TextView) itemView.findViewById(R.id.link);
                tipe    = (TextView) itemView.findViewById(R.id.tipe);
                waktu   = (TextView) itemView.findViewById(R.id.waktu) ;

            }

            void bind(News item) {
                judul.setText(String.valueOf(item.getJudul()));
                link.setText(String.valueOf(item.getLink()));
                tipe.setText(String.valueOf(item.getTipe()));
                waktu.setText(String.valueOf(item.getWaktu()));
                Picasso.with(this.context)
                        .load(""+item.getPoster())
                        .placeholder(android.R.drawable.ic_dialog_alert)
                        .error(android.R.drawable.ic_dialog_alert)
                        .into(poster);

                currentItem = item;

            }

            @Override
            public void onClick(View v) {

            }
        }

    }
