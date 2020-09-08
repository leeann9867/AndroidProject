package com.example.folyfinalproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import kotlinx.android.synthetic.main.activity_map.*


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mapView: MapView? = null
    private val marker = Marker()
    private val marker1 = Marker()
    private val marker2 = Marker()
    private val infoWindow = InfoWindow()
    private val infoWindow1 = InfoWindow()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("nnv85idnj2")
        //폴리텍 마커
        marker.setOnClickListener {
            Toast.makeText(this, "한국폴리텍대학교", Toast.LENGTH_SHORT).show()
            true

        }
        //네이버 정보창
        infoWindow.adapter = object : InfoWindow.DefaultTextAdapter(application) {
            override fun getText(infoWindow: InfoWindow): CharSequence {

                return "명륜진사갈비 부천송내점\n ★4.4 육류,고기요리"
            }
        }
        infoWindow1.adapter = object : InfoWindow.DefaultTextAdapter(application) {
            override fun getText(infoWindow: InfoWindow): CharSequence {
                return "채선당 송내점\n ★4.3 샤브샤브"
            }
        }

        //네이버 지도
        mapView = findViewById<View>(R.id.map) as MapView
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync(this)
    }


   override fun onMapReady(naverMap: NaverMap) {
       //뷰 클릭시 마커위치랑 정보 표시
       var count = 1;
       var couunt = 1;
       cookview.setOnClickListener {
           if(count == 1) {
               cookview2.setBackgroundResource(R.drawable.border_rouund)
               cookview.setBackgroundResource(R.drawable.border_click)
               val cameraPosition = CameraPosition(
                   LatLng(37.485384, 126.752684),  // 위치 지정
                   14.0,  // 줌 레벨
                   0.0,  // 기울임 각도
                   0.0 // 방향
               )

               naverMap.cameraPosition = cameraPosition
               marker2.map = null
               marker1.position = LatLng(37.485384, 126.752684)
               marker1.icon = OverlayImage.fromResource(R.drawable.marker1)
               marker1.map = naverMap
               infoWindow.open(marker1)
               count = 0
               couunt = 1
           }
           else if(count == 0){
               cookview.setBackgroundResource(R.drawable.border_rouund)
               marker1.map = null
               count = 1
               couunt = 1
           }

       }
       cookview2.setOnClickListener {
           if(couunt == 1) {
               cookview.setBackgroundResource(R.drawable.border_rouund)
               cookview2.setBackgroundResource(R.drawable.border_click)

               marker1.map = null
               val cameraPosition = CameraPosition(
                   LatLng(37.488331, 126.752209),  // 위치 지정
                   14.0,  // 줌 레벨
                   0.0,  // 기울임 각도
                   0.0 // 방향
               )

               naverMap.cameraPosition = cameraPosition
               marker2.position = LatLng(37.488331, 126.752209)
               marker2.icon = OverlayImage.fromResource(R.drawable.marker1)
               marker2.map = naverMap
               infoWindow1.open(marker2)
               couunt = 0
               count = 1
           }
           else if(couunt == 0){
               cookview2.setBackgroundResource(R.drawable.border_rouund)
               marker2.map = null
               couunt = 1
               count = 1
           }
       }


//처음 위치랑 마커 폴리텍 표시
       marker.position = LatLng(37.478438, 126.755232)
       marker.icon = OverlayImage.fromResource(R.drawable.marker)
       marker.map = naverMap
       val cameraPosition = CameraPosition(
            LatLng(37.478594, 126.755259),  // 위치 지정
            14.0,  // 줌 레벨
            0.0,  // 기울임 각도
            0.0 // 방향
        )

       naverMap.cameraPosition = cameraPosition

   }

    public override fun onStart() {
        super.onStart()
        mapView!!.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView!!.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView!!.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView!!.onLowMemory()
    }

    companion object {
        private val naverMap: NaverMap? = null
    }
}