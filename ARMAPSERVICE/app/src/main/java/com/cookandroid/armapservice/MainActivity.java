package com.cookandroid.armapservice;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.util.FusedLocationSource;

public class MainActivity  extends FragmentActivity implements OnMapReadyCallback{

    public static final int LOCATION_PERMISSION_REQUESTS_CODE = 1000;
    public static final String [] PERMISSIONS ={
            Manifest.permission.ACCESS_FINE_LOCATION ,
            Manifest.permission.ACCESS_COARSE_LOCATION
    } ;

    private NaverMap naverMap;
    private MapView mapView;
    private FusedLocationSource locationSource;
    Button btnAR;

    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAR = (Button)findViewById(R.id.ARbutton);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUESTS_CODE);

        btnAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"AR모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                /*
                *  이 부분에 AR모드 ACTIVITY로 전환하는 코드 작성.
                * */
            }
        });

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String [] permissions, @NonNull int [] grantResults ){

        if (locationSource.onRequestPermissionsResult(requestCode, permissions,grantResults)){
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // ...
        this.naverMap = naverMap;
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRANSIT, true);
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Face);

        naverMap.setOnSymbolClickListener(symbol -> {       //심벌 클릭 이벤트 리스너, 심벌의 정보는 symbol에 담겨나온다.

            Toast.makeText(this, symbol.getCaption()+"의 좌표는 : "+symbol.getPosition(), Toast.LENGTH_SHORT).show();
            return true;

            // 이벤트 전파, OnMapClick 이벤트가 발생함
        });
    }

}

