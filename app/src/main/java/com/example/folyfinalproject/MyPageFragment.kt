package com.example.folyfinalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.fragment_my.*

class MyPageFragment : Fragment() {

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : MyPageFragment {
            return MyPageFragment()
        }

    }

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "PagFragment - onCreate() called")
    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "PagFragment - onAttach() called")
    }

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        Log.d(TAG, "PagFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_my, container, false)

        return view


        btn_Book.setOnClickListener {
            var intent = Intent(this, BookActivity::class.java)
            startActivity(intent)
        }

        btn_ChangeTend.setOnClickListener {
            var intent = Intent(this, ChangeTendencyActivity::class.java)
            startActivity(intent)
        }

        btn_Coupon.setOnClickListener {
            var intent = Intent(this, CouponActivity::class.java)
            startActivity(intent)
        }

        btn_Help.setOnClickListener {
            var intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }

        btn_Logout.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btn_Point.setOnClickListener {
            var intent = Intent(this, PointActivity::class.java)
            startActivity(intent)
        }

        btn_Review.setOnClickListener {
            var intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        btn_Setting.setOnClickListener {
            var intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        btn_VerInfo.setOnClickListener {
            var intent = Intent(this, VersionInfoActivity::class.java)
            startActivity(intent)
        }
    }

}