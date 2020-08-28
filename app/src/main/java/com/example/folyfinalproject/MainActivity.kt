package com.example.folyfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jeongdaeri.bottomnavwithfragments.HomeFragment
import com.jeongdaeri.bottomnavwithfragments.MyPageFragment
import com.jeongdaeri.bottomnavwithfragments.OrderListFragment
import com.jeongdaeri.bottomnavwithfragments.SmartOrderFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //--------------------------------------------------------- 박세진_0829 ver.1
    private lateinit var homeFragment: HomeFragment
    private lateinit var smartOrderFragment: SmartOrderFragment
    private lateinit var orderListFragment: OrderListFragment
    private lateinit var myPageFragment: MyPageFragment
    //--------------------------------------------------------- 박세진_0829 ver.1

    //--------------------------------------------------------- 박세진_0829 ver.1
    companion object {

        const val TAG: String = "로그"

    }
    //--------------------------------------------------------- 박세진_0829 ver.1

    //--------------------------------------------------------- 박세진_0829 ver.1
    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()

    }
    //--------------------------------------------------------- 박세진_0829 ver.1
    //--------------------------------------------------------- 박세진_0829 ver.1
    // 바텀네비게이션 아이템 클릭 리스너 설정
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈버튼 클릭!")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.smart_order -> {
                Log.d(TAG, "MainActivity - 스마트오더 클릭!")
                smartOrderFragment = SmartOrderFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, smartOrderFragment).commit()
            }
            R.id.order_list -> {
                Log.d(TAG, "MainActivity - 오더리스트 클릭!")
                orderListFragment = OrderListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, orderListFragment).commit()
            }
            R.id.menu_my -> {
                Log.d(TAG, "MainActivity - 오더리스트 클릭!")
                myPageFragment = MyPageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, myPageFragment).commit()
            }

        }

        true
    }
    //--------------------------------------------------------- 박세진_0829 ver.1



    //※MainActivity에 추가 기능을 넣을 경우 여기서부터 작성하시오!!!※
    //onCreate 31번째 줄에 존재합니다.
    //여기서부터 스타트↓




}//마지막 }입니다(13번쨰줄)