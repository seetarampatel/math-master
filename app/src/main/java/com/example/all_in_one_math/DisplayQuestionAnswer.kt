package com.example.all_in_one_math

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_display_question_answer.*
import kotlinx.android.synthetic.main.item_question.view.*

class DisplayQuestionAnswer : AppCompatActivity() {

    // Firestore connection
    val database = FirebaseFirestore.getInstance()
    private var adapter: QAForumAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_question_answer)

        questionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val query = database.collection("questions").orderBy("userName", Query.Direction.ASCENDING)

        val options = FirestoreRecyclerOptions.Builder<QAForum>().setQuery(query, QAForum::class.java).build()
        adapter = QAForumAdapter(options)
        questionsRecyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        if(adapter != null) {
            adapter!!.stopListening()
        }
    }

    private inner class QAForumViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view) {

    }

    private inner class QAForumAdapter internal constructor(options: FirestoreRecyclerOptions<QAForum>) :
            FirestoreRecyclerAdapter<QAForum, QAForumViewHolder>(options) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAForumViewHolder {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
            return QAForumViewHolder(view)
        }

        override fun onBindViewHolder(holder: QAForumViewHolder, position: Int, model: QAForum) {
            holder.itemView.userNameTextView.text = model.userName
            holder.itemView.questionTextView.text = model.question
        }
    }
}


