package com.example.carlos.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity   extends FragmentActivity
        implements GoogleMap.OnMapClickListener {
    private final LatLng USM = new LatLng(-33.034853, -71.594332);
    private final LatLng CONT1 = new LatLng(-33.037983, -71.596295);
    private final LatLng CONT2 = new LatLng(-33.038154, -71.592948);
    private final LatLng CONT3 = new LatLng(-33.032982, -71.590544);
    private GoogleMap mapa; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapa = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(USM, 16));

        mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
        mapa.addMarker(new MarkerOptions()
                .position(USM)
                .title("USM")
                .snippet("UTFSM Centro de Operaciones")
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));
        mapa.setOnMapClickListener(this);
        mapa.addMarker(new MarkerOptions()
                .position(CONT1)
                .title("CONTENEDOR 1")
                .snippet("Escuelita")
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));
        mapa.setOnMapClickListener(this);
        mapa.addMarker(new MarkerOptions()
                .position(CONT2)
                .title("CONTENEDOR 2")
                .snippet("Local Sushi")
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));
        mapa.setOnMapClickListener(this);
        mapa.addMarker(new MarkerOptions()
                .position(CONT3)
                .title("CONTENEDOR 3")
                .snippet("Amsterdam")
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));
        mapa.setOnMapClickListener(this);
    }

    public void moveCamera(View view) {
        mapa.moveCamera(CameraUpdateFactory.newLatLng(USM));
    }

    public void animateCamera(View view) {
        if (mapa.getMyLocation() != null)
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng( mapa.getMyLocation().getLatitude(),
                            mapa.getMyLocation().getLongitude()), 16));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions().position(
                new LatLng(mapa.getCameraPosition().target.latitude,
                        mapa.getCameraPosition().target.longitude)));
    }

    @Override
    public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions().position(puntoPulsado).
                icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }
}