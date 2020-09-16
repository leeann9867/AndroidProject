package com.example.folyfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_joininfo.*

class JoinInfoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joininfo)

        auth = FirebaseAuth.getInstance()


        join_hu2.setOnClickListener {


            if (join_info_google_email_area.text.toString() == " ") {
                Log.e("JoinInfoActivity", "실패")
            } else {
                Log.e("JoinInfoActivity", "성공")
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        val nickname = hashMapOf(

            "nickname" to join_info_google_email_area.text.toString()

        )

        db.collection("nickname")
            .document(auth.currentUser?.uid.toString())
            .set(nickname)
            .addOnSuccessListener {
                Log.e("JoinInfoActivity", "성공")
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Log.e("JoinInfoActivity", "실패")


            }
    }
}


