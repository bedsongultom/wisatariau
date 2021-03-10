package com.bedsongultom.wisatariau.ui.video;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.gallery.Galleries;
import com.bedsongultom.wisatariau.ui.gallery.GalleryAdapter;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;

import java.util.ArrayList;

public class VideoFragment  extends Fragment {

    RecyclerView rc;
    VideoAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private Context context;


    private VideoViewModel videoViewModel;
    //AIzaSyA9XAWqlEZRRqZdfu8uM1S66KM6-V2IqcE
    //AIzaSyABKd34ZEtwi5az1CIQCad3-K8b5420gCQ
    private static final String YoutubeDeveloperKey = "AIzaSyA9XAWqlEZRRqZdfu8uM1S66KM6-V2IqcE";
    private YouTubePlayer youTubePlayer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        videoViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_video, container, false);
        final TextView textView = root.findViewById(R.id.text_video);


        YouTubePlayerSupportFragmentX youTubePlayerSupportFragmentX = (YouTubePlayerSupportFragmentX) getChildFragmentManager().findFragmentById(R.id.youTubePlayer);
        youTubePlayerSupportFragmentX = YouTubePlayerSupportFragmentX.newInstance();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.youTubePlayer, youTubePlayerSupportFragmentX);
        fragmentTransaction.commit();


        youTubePlayerSupportFragmentX.initialize(YoutubeDeveloperKey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    //  youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    //youTubePlayer.setFullscreen(true);
                    youTubePlayer.cueVideo("OWiOW1qU_H8");

                    /*youTubePlayer.play();*/

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        videoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return root;
    }
}

