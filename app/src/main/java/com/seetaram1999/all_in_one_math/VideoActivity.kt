package com.seetaram1999.all_in_one_math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.android.synthetic.main.activity_video.backButton

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        // array of all formula buttons
        val videos_list = arrayOf(algebraButton, arithmeticButton, calculusButton, trigonometryButton)

        // Iterate through all the buttons of the formulas_list array and open the intent for each specific button
        for(item in 0..videos_list.size - 1) {
            videos_list[item].setOnClickListener {
                val intent = Intent(applicationContext, DisplayVideoActivity::class.java)
                // Pass the Formula category name to the FormulaDetailsActivity page for header
                intent.putExtra("VideoCategory", videos_list[item].text)
                startActivity(intent)
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}