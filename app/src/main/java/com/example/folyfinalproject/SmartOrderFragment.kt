package com.example.folyfinalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment



class SmartOrderFragment : Fragment() {
    lateinit var btn_smo : Button

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : SmartOrderFragment {
            return SmartOrderFragment()
        }

    }

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SmartOrderFragment - onCreate() called")

    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "SmartOrderFragment - onAttach() called")
    }

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "SmartOrderFragment - onCreateView() called")
        val view = inflater.inflate(R.layout.fragment_smart_order, null)
        val map = view.findViewById<Button>(R.id.btn_smo)


        map.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, MapActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        })
        return view
    }

}
