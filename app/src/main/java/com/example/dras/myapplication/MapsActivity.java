package com.example.dras.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity   extends FragmentActivity
        implements GoogleMap.OnMapClickListener {
    private final LatLng CMD = new LatLng(-33.036736, -71.590826); //mi casa
    private final LatLng USM = new LatLng(-33.034853, -71.594332); //usm
    private final LatLng CONT1 = new LatLng(-33.036245, -71.592401); //cafe marengo
    private final LatLng CONT2 = new LatLng(-33.037191, -71.596314); // nony
    private final LatLng CONT3 = new LatLng(-33.037992, -71.600391); //shell
    private final LatLng CONT4 = new LatLng(-33.038067, -71.592436);// amasanderia angelito
    private final LatLng CONT5 = new LatLng(-33.040311, -71.593048); //el rapido
    private final LatLng CONT6 = new LatLng(-33.032656, -71.592391);
    private final LatLng CONT7 = new LatLng(-33.040140, -71.591554);
    private final LatLng CONT8 = new LatLng(-33.031253, -71.589966);
    private final LatLng CONT9 = new LatLng(-33.039402, -71.600738);
    private final LatLng CONT10 = new LatLng(-33.040769, -71.608484);
    private GoogleMap mapa; // Might be null if Google Play services APK is not available.
    public Marker mark1;
    public Marker mark2;
    public Marker mark3;
    public Marker mark4;
    public Marker mark5;
    public Marker mark6;

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
        mapa.getUiSettings().setRotateGesturesEnabled(true);
//        mapa.getUiSettings().setMapToolbarEnabled(true);
//        mapa.setContentDescription("Plano de Reciclaje");


        mapa.addMarker(new MarkerOptions()
                .position(USM)
                .title("GEA UTFSM")
                .snippet("Eco-Sansano Avenida España 1680")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.utfsm))
                .anchor(0.5f, 0.5f));

        mapa.addMarker(new MarkerOptions()
                .position(CMD)
                .title("Centro de Mando")
                .snippet("Javiera Carrera 367")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.antenna))
                .anchor(0.5f, 0.5f));

        mark1 = mapa.addMarker(new MarkerOptions()
                .position(CONT1)
                .title("Cafe Marengo")
                .snippet("Av. Matta 259 (Carton y Plasticos)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_empty))
                .anchor(0.5f, 0.5f));

        mark2 = mapa.addMarker(new MarkerOptions()
                .position(CONT2)
                .title("Nony")
                .snippet("Los Placeres 270")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_empty))
                .anchor(0.5f, 0.5f));

        mark3 = mapa.addMarker(new MarkerOptions()
                .position(CONT3)
                .title("Shell")
                .snippet("Direccion NN")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_empty))
                .anchor(0.5f, 0.5f));

        mark4 = mapa.addMarker(new MarkerOptions()
                .position(CONT4)
                .title("Amasanderia Angelito")
                .snippet("Calle San Guillermo 599")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_full))
                .anchor(0.5f, 0.5f));


        mark5 = mapa.addMarker(new MarkerOptions()
                .position(CONT5)
                .title("El rapido")
                .snippet("Calle Carmen 493")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_full))
                .anchor(0.5f, 0.5f));

        mark6 = mapa.addMarker(new MarkerOptions()
                .position(CONT6)
                .title("Almacen Chile")
                .snippet("Calle Carmen 493")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trash_full))
                .anchor(0.5f, 0.5f));

        mapa.setOnMapClickListener(this); //sirve para el marcador amarillo
    }

    public void moveCamera(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLng(USM));
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else {
            mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    public void onToggleClicked2(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            mark1.setVisible(false);
            mark2.setVisible(false);
            mark3.setVisible(false);
        } else {
            mark1.setVisible(true);
            mark2.setVisible(true);
            mark3.setVisible(true);
        }
    }

    public void animateCamera(View view) {
        if (mapa.getMyLocation() != null)
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng( mapa.getMyLocation().getLatitude(),
                            mapa.getMyLocation().getLongitude()), 16));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(mapa.getCameraPosition().target.latitude,
                        mapa.getCameraPosition().target.longitude))
                .draggable(true));
    }

    @Override
    public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions()
                .position(puntoPulsado)
                .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.contenedor)));
    }
}