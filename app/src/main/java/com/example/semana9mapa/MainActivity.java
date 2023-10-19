package com.example.semana9mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){

        myMap = googleMap;

        //CREAR 3 DE ESTOS PARA UBICACIONES LA SERENA, COQUIMBO Y OVALLE
        LatLng ubicacion = new LatLng(-30.6045845, -71.2073349);

        //ACÁ MUESTRA LA UBICACIÓN MARCADA
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("IP SANTO TOMAS"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        //LO QUE PERMITE HACER EL MAPA
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);

        //LO QUE NO PERMITE HACER EL MAPA
        myMap.getUiSettings().setZoomGesturesEnabled(false);
        myMap.getUiSettings().setScrollGesturesEnabled(false);
    }

}