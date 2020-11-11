package com.example.all_in_one_math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question_answer.*

class QuestionAnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_answer)

        saveQuestionButton.setOnClickListener {
            if((!TextUtils.isEmpty(questionPublisherName.text)) && (!TextUtils.isEmpty(questionEditText.text))) {
                val forum = QAForum()
                forum.userName = questionPublisherName.text.toString().trim()
                forum.question = questionEditText.text.toString().trim()

                val database = FirebaseFirestore.getInstance().collection("questions")
                forum.id = database.document().id
                database.document(forum.id!!).set(forum)

                questionPublisherName.setText("")
                questionEditText.setText("")
                Toast.makeText(this, "Question Posted", Toast.LENGTH_LONG).show()

                val intent = Intent(applicationContext, DisplayQuestionAnswer::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this,"Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }
}