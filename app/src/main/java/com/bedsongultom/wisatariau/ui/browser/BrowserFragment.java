package com.bedsongultom.wisatariau.ui.browser;

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
import com.bedsongultom.wisatariau.ui.home.HomeViewModel;

public class BrowserFragment extends Fragment {
    private BrowserViewModel browserViewModel;
    WebView wBrowser;
    ProgressBar pBrowser;
    String linkdetail = "linkdetail";
    String a;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        browserViewModel =
                ViewModelProviders.of(this).get(BrowserViewModel.class);

        View root = inflater.inflate(R.layout.fragment_browser, container, false);
        final TextView textView = root.findViewById(R.id.text_browser);

        wBrowser = (WebView) root.findViewById(R.id.wBrowser);
        pBrowser = (ProgressBar) root.findViewById(R.id.pBrowser);

        //mengenali notasi dihtml
        wBrowser.setWebViewClient(new WebViewClient());
        // untuk penggunaan browser
        wBrowser.getSettings().setJavaScriptEnabled(true);


        wBrowser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wBrowser.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pBrowser.setVisibility(View.VISIBLE);
                if (newProgress == 100) {
                    pBrowser.setVisibility(View.GONE);
                }
            }
        });


        browserViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Bundle bundle = new Bundle();

        if (bundle != null) {
            bundle = getArguments();
            a = bundle.getString(linkdetail);
            wBrowser.loadUrl(a);
            return root;
        } else {
            wBrowser.loadUrl("https://duckduckgo.com");
        }
        return root;
    }


}