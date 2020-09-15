package com.example.folyfinalproject
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.folyfinalproject.R

import kotlinx.android.synthetic.*

class HomeFragment : Fragment() {
    lateinit var btn_korea: ImageButton
    lateinit var btn_chaina: ImageButton
    lateinit var btn_japan: ImageButton
    lateinit var btn_euro: ImageButton
    lateinit var btn_asian: ImageButton
    lateinit var btn_food1: ImageButton
    lateinit var btn_food2: ImageButton
    lateinit var btn_food3: ImageButton
    lateinit var btn_food4: ImageButton
    lateinit var btn_food5: ImageButton
    lateinit var btn_food6: ImageButton
    lateinit var btn_food7: ImageButton

    companion object {
        const val TAG: String = "로그"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate() called")

    }
        // 프레그먼트를 안고 있는 액티비티에 붙었을 때
        override fun onAttach(context: Context) {
            super.onAttach(context)
            Log.d(TAG, "HomeFragment - onAttach() called")

        }

        // 뷰가 생성되었을 때
        // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            Log.d(TAG, "HomeFragment - onCreateView() called")
            val view = inflater.inflate(R.layout.fragment_home, container, false)






            return view
        }
    }



