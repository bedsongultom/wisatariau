package com.bedsongultom.wisatariau.ui.about;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.map.MapViewModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        final TextView textView = root.findViewById(R.id.textView_name);
        final ImageView imageView  = root.findViewById(R.id.img_file);
        final TextView tvEmail    = root.findViewById(R.id.tvEmail);
        tvEmail.setMovementMethod(LinkMovementMethod.getInstance());


        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_about_developer));

        //imageView.setLayerType(imageView.LAYER_TYPE_SOFTWARE,null);
        final TextView tvTelegram = (TextView)root.findViewById(R.id.tv_telegram);
        tvTelegram.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView tvYoutube = (TextView) root.findViewById(R.id.tv_youtube);
        tvYoutube.setMovementMethod(LinkMovementMethod.getInstance());

        aboutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}