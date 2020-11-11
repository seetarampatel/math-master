package com.example.all_in_one_math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intents for various activities
        aboutUsButton.setOnClickListener {
            val intent = Intent(applicationContext, AboutUsActivity::class.java)
            startActivity(intent)
        }

        formulasButton.setOnClickListener {
            val intent = Intent(applicationContext, FormulasActivity::class.java)
            startActivity(intent)
        }

        videoButton.setOnClickListener {
            Toast.makeText(this, "Feature will available in near future", Toast.LENGTH_LONG).show()
        }

        questionsButton.setOnClickListener {
            val intent = Intent(applicationContext, QuestionAnswerActivity::class.java)
            startActivity(intent)
        }

        // Logout button listener - finish the session and send user to the sign in page
        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()

            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}