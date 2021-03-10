package com.bedsongultom.wisatariau.ui.newsdetails;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.browser.BrowserFragment;
import com.bedsongultom.wisatariau.ui.web.WebFragment;
import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.squareup.picasso.Picasso;

public class NewsDetailFragment extends Fragment {
    ImageView posterdetail;
    TextView juduldetail;
    TextView tipedetail;
    TextView linkdetail;
    TextView waktudetail;
    DocumentView documentView;

    String a, b, c, d,e, f;
    String poster="poster";
    String judul ="judul";
    String tipe="tipe";
    String link="link";
    String waktu="waktu";
    String kutipan="kutipan";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        NewsDetailViewModel newsDetailViewModel = ViewModelProviders.of(this).get(NewsDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_newsdetail, container, false);

        final TextView textView = root.findViewById(R.id.text_newdetail);
        posterdetail = root.findViewById(R.id.poster_detail);
        juduldetail  = root.findViewById(R.id.judul_detail);
        waktudetail  = root.findViewById(R.id.waktu_detail);
        linkdetail   = root.findViewById(R.id.link_detail);
        tipedetail   = root.findViewById(R.id.tipe_detail);

        documentView = root.findViewById(R.id.kutipan_detail);
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);

        Bundle bundle = new Bundle();

        if (bundle != null) {
            bundle = getArguments();
            a = bundle.getString(poster);  // key must be same which was given in first fragment
            b = bundle.getString(judul);
            c = bundle.getString(tipe);

            d = bundle.getString(link);
            e = bundle.getString(waktu);
            f = bundle.getString(kutipan);

            juduldetail.setText(b);
            linkdetail.setText(d);
            waktudetail.setText(e);
            documentView.setText(f);
            tipedetail.setText(c);

            Picasso.with(getContext())
                    .load(""+a)
                    .error(android.R.drawable.ic_dialog_alert)
                    .placeholder(android.R.drawable.ic_dialog_alert)
                    .into(posterdetail);
        }

        linkdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BrowserFragment fragment = new BrowserFragment(); // replace your custom fragment class
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                bundle.putString("linkdetail", String.valueOf(linkdetail.getText()));



                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_newsdetail,fragment);
                fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove();
                fragmentTransaction.commit();


            }
        });


        newsDetailViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return root;
    }



}
