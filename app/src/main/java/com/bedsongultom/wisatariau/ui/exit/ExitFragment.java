package com.bedsongultom.wisatariau.ui.exit;

import androidx.fragment.app.FragmentManager;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.home.HomeFragment;
import com.bedsongultom.wisatariau.ui.home.HomeViewModel;

public class ExitFragment extends Fragment {

    private ExitViewModel exitViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exitViewModel =
                ViewModelProviders.of(this).get(ExitViewModel.class);

        View root = inflater.inflate(R.layout.fragment_exit, container, false);
        final TextView textView = root.findViewById(R.id.text_exit);
        final Button btnYes = root.findViewById(R.id.btnYes);
        final Button btnNo  = root.findViewById(R.id.btnNo);
        final Fragment me = this;


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getFragmentManager().beginTransaction().remove(me).commit();
                getActivity().finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

            }
        });

        exitViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}