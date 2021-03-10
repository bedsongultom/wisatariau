package com.bedsongultom.wisatariau.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bedsongultom.wisatariau.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener{
    GoogleMap map;
    Button a, b,c,d;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapViewModel mapViewModel = ViewModelProviders.of(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        final TextView textView = root.findViewById(R.id.text_map);

        SupportMapFragment mp = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        if (mp != null) {
            mp.getMapAsync(this);
        }

        a = root.findViewById(R.id.normal);
        b = root.findViewById(R.id.satelite);
        c = root.findViewById(R.id.hybrid);
        d = root.findViewById(R.id.terrain);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);

        mapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.normal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satelite:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.hybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.terrain:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //for add langtitude
        LatLng candi_muaratakus  = new LatLng(0.336273, 100.641991);
        LatLng airterjun_lubuklinggau = new LatLng(-3.274441, 102.945087);
        LatLng alam_mayang = new LatLng(0.492228, 101.500567);
        LatLng istana_siak = new LatLng(0.795070, 102.048976);

        LatLng kebun_binatang_kulim = new LatLng(0.419027, 101.406663);
        LatLng water_park_labersa = new LatLng(0.446700, 101.477528);
        LatLng pulau_jemur = new LatLng(2.889617, 100.570817);
        LatLng sungai_kampar = new LatLng(0.399417, 102.171623);
        LatLng mesjid_agung_an_nur = new LatLng(0.526867, 101.450887);
        LatLng pulau_aruah = new LatLng(3.435971, 100.710782);

        map.addMarker(new MarkerOptions().position(candi_muaratakus).title("Candi Muara Takus"));
        map.addMarker(new MarkerOptions().position(airterjun_lubuklinggau).title("Air Terjun Lubuk Linggau "));
        map.addMarker(new MarkerOptions().position(alam_mayang).title("Wisata Alam Mayang"));
        map.addMarker(new MarkerOptions().position(istana_siak).title("Instana Siak "));
        map.addMarker(new MarkerOptions().position(kebun_binatang_kulim).title("Kebun Binatang Kasang Kulim"));
        map.addMarker(new MarkerOptions().position(water_park_labersa).title("Water Park Labersa "));
        map.addMarker(new MarkerOptions().position(pulau_jemur).title("Pulau Jemur"));
        map.addMarker(new MarkerOptions().position(sungai_kampar).title("Sungai Kampar "));
        map.addMarker(new MarkerOptions().position(mesjid_agung_an_nur).title("Mesjid Agung An Nur"));
        map.addMarker(new MarkerOptions().position(pulau_aruah).title("Pulau Aruah "));
        //for camera focus
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(candi_muaratakus,5.0f));
    }
}