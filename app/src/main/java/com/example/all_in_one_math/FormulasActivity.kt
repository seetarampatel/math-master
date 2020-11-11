package com.example.all_in_one_math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulas.*

class FormulasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulas)

        val formulas_list = arrayOf(algebraButton, arithmeticButton, calculusButton, trigonometryButton)

        for(item in 0..formulas_list.size - 1) {
            formulas_list[item].setOnClickListener {
                val intent = Intent(applicationContext, FormulaDetailsActivity::class.java)
                intent.putExtra("FormulaCategory", formulas_list[item].text)
                startActivity(intent)
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}