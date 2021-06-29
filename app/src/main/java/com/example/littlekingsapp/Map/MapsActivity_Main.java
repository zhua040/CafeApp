package com.example.littlekingsapp.Map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.littlekingsapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_Main extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng littleKing = new LatLng(-36.77301, 174.76673);
        mMap.addMarker(new MarkerOptions().position(littleKing).title("132,Kitchener Road Auckland 0620"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(littleKing));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(littleKing, 12.0f));
    }
}