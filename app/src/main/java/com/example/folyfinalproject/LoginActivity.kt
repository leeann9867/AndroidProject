package com.example.folyfinalproject


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        login_button.setOnClickListener {


            auth.signInWithEmailAndPassword(login_email_area.text.toString(), login_password_area.text.toString())
                .addOnCompleteListener(this){task ->

                    if(task.isSuccessful){
                        Toast.makeText(this, "로그인 성공하셨습니다.", Toast.LENGTH_LONG).show()
                        var intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    }else {

                        Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()

                    }

                }


        }
        login_IdSearch.setOnClickListener {
            val intent = Intent(this, IdFindActivity::class.java)
            startActivity(intent)
        }
        login_PasswordSearch.setOnClickListener {
            val intent = Intent(this, PasswordFindActivity::class.java)
            startActivity(intent)
        }

        google_login_button2.setOnClickListener {

            signIn()


        }
        join_hu1.setOnClickListener {

            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)


        }
      
    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == LoginActivity.RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

                val intent = Intent(this, JoinInfogoogleActivity::class.java)
                startActivity(intent)

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(LoginActivity.TAG, "이미 로그인 하셨습니다", e)
                // ...
            }
        }
    }
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, LoginActivity.RC_SIGN_IN)
    }
    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(LoginActivity.TAG, "firebaseAuthWithGoogle:" + acct.id!!)
        // [START_EXCLUDE silent]

        // [END_EXCLUDE]

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(LoginActivity.TAG, "signInWithCredential:success")
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(LoginActivity.TAG, "signInWithCredential:failure", task.exception)


                }

            }
    }
}
