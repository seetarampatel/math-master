package com.seetaram1999.all_in_one_math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulas.*

class FormulasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulas)

        // array of all formula buttons
        val formulas_list = arrayOf(algebraButton, arithmeticButton, calculusButton, trigonometryButton)

        // Iterate through all the buttons of the formulas_list array and open the intent for each specific button
        for(item in 0..formulas_list.size - 1) {
            formulas_list[item].setOnClickListener {
                val intent = Intent(applicationContext, FormulaDetailsActivity::class.java)
                // Pass the Formula category name to the FormulaDetailsActivity page for header
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