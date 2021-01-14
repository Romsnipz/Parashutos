package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private Bundle savedInstanceState;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double lat = 55.66210111437797;
        double lng = 36.14212287959177;
        LatLng point1 = new LatLng(lat, lng);

        double lat1 = 56.16376500312994;
        double lng1 = 38.83068383594745;
        LatLng point2 = new LatLng(lat1, lng1);

        double lat0 = 55.685762;
        double lng0 = 37.539026;
        LatLng myloc = new LatLng(lat0, lng0);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(myloc).zoom(12).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(cameraUpdate);
        mMap.addMarker(new MarkerOptions().position(myloc).draggable(true).title("My location"));
        mMap.addMarker(new MarkerOptions().position(point1).title("Ватулино"));
        mMap.addMarker(new MarkerOptions().position(point2).title("Киржач"));

        if(null != googleMap){
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat, lng))
                    .title("Mark")
                    .draggable(false)
            );
        }
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings1:
                Intent intent = new Intent(MapActivity.this, RegActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                Intent intent1 = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
