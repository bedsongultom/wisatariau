package com.bedsongultom.wisatariau.ui.web;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.web.WebViewModel;

public class WebFragment extends Fragment {

    private WebViewModel webViewModel;
    WebView wb;
    ProgressBar pb;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        webViewModel =
                ViewModelProviders.of(this).get(WebViewModel.class);
        View root = inflater.inflate(R.layout.fragment_web, container, false);
        final TextView textView = root.findViewById(R.id.text_web);
        wb = (WebView) root.findViewById(R.id.web_view);
        pb = (ProgressBar) root.findViewById(R.id.pb);

        //mengenali notasi dihtml
        wb.setWebViewClient(new WebViewClient());
        // untuk penggunaan browser
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
             super.onProgressChanged(view, newProgress);
                pb.setVisibility(View.VISIBLE);
                if (newProgress == 100){
                    pb.setVisibility(View.GONE);
                }
             }
         });


        webViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        wb.loadUrl("https://destinasi.riau.go.id");
        return root;

    }
}