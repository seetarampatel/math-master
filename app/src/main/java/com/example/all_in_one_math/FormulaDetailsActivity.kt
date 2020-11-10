package com.example.all_in_one_math

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formula_details.*

/**
 * Formula Reference: Byjus,
 */
class FormulaDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula_details)

        formulaDetailsHeadingTextView.text = intent.getStringExtra("FormulaCategory")
        val formulaCategoryName = formulaDetailsHeadingTextView.text

        if(formulaCategoryName == "Algebra") {
            formulaDetialsMultipleTextView.setText(
                "\u2022 a2 – b2 = (a – b)(a + b)\n" +
                "\u2022 (a + b)2 = a2 + 2ab + b2\n" +
                "• (a – b)2 = a2 – 2ab + b2\n" +
                "• (a + b + c)2 = a2 + b2 + c2 + 2ab + 2bc + 2ca\n" +
                "• (a – b – c)2 = a2 + b2 + c2 – 2ab + 2bc – 2ca\n" +
                "• a3 – b3 = (a – b)(a2 + ab + b2)\n" +
                "• a3 + b3 = (a + b)(a2 – ab + b2)\n" +
                "• (a + b)4 = a4 + 4a3b + 6a2b2 + 4ab3 + b4\n" +
                "• (a – b)4 = a4 – 4a3b + 6a2b2 – 4ab3 + b4\n" +
                "• a4 – b4 = (a – b)(a + b)(a2 + b2)\n" +
                "• a5 – b5 = (a – b)(a4 + a3b + a2b2 + ab3 + b4)"
            )
        }
        else if(formulaCategoryName == "Arithmetic") {
            formulaDetialsMultipleTextView.setText(
                "• a + b = b + a\n" +
                "• a * b = b * a\n" +
                "• (a + b) + c = a + (b + c)\n" +
                "• (a * b) * c = a * (b * c)\n" +
                "• a * 1 = a\n" +
                "• a / 1 = a\n" +
                "• a * 0 = 0\n"
            )
        }
        else if(formulaCategoryName == "Calculus") {
            formulaDetialsMultipleTextView.setText(
                "• ∫ 1 dx = x + C\n" +
                "• ∫ a dx = ax+ C\n" +
                "• ∫ xn dx = ((xn+1)/(n+1))+C ; n≠1\n" +
                "• ∫ sin x dx = – cos x + C\n" +
                "• ∫ cos x dx = sin x + C\n" +
                "• ∫ sec2 dx = tan x + C\n" +
                "• ∫ csc2 dx = -cot x + C\n" +
                "• ∫ sec x (tan x) dx = sec x + C\n" +
                "• ∫ csc x ( cot x) dx = – csc x + C\n" +
                "• ∫ (1/x) dx = ln |x| + C\n" +
                "• ∫ ex dx = ex+ C\n" +
                "• ∫ ax dx = (ax/ln a) + C ; a>0,  a≠1"
            )
        }
        else {
            formulaDetialsMultipleTextView.setText(
                "• sin(x+y) = sin(x)cos(y)+cos(x)sin(y)\n" +
                "• cos(x+y) = cos(x)cos(y)–sin(x)sin(y)\n" +
                "• tan(x+y) = (tan x + tan y)/ (1−tan x •tan y)\n" +
                "• sin(x–y) = sin(x)cos(y)–cos(x)sin(y)\n" +
                "• cos(x–y) = cos(x)cos(y) + sin(x)sin(y)\n" +
                "• tan(x−y) = (tan x–tan y)/ (1+tan x • tan y)\n" +
                "• Sin 3x = 3sin x – 4sin3x\n" +
                "• Cos 3x = 4cos3x-3cos x\n" +
                "• Tan 3x = [3tanx-tan3x]/[1-3tan2x]"
            )
        }

    }
}