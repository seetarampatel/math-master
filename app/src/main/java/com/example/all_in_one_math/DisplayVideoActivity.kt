package com.example.all_in_one_math

import android.content.Intent
import android.net.Uri
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_us.*
import kotlinx.android.synthetic.main.activity_display_video.*
import kotlinx.android.synthetic.main.activity_formula_details.*

class DisplayVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_video)

        displayVideoNameHeadingTextView.text = intent.getStringExtra("VideoCategory")
        val videoCategoryName = displayVideoNameHeadingTextView.text

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        if(videoCategoryName == "Algebra") {
            val algebraVideo = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(algebraVideo)
        }
        else if(videoCategoryName == "Arithmetic") {
            val arithmeticVideo = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(arithmeticVideo)
        }
        else if(videoCategoryName == "Calculus") {
            val calculusVideo = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(calculusVideo)
        }
        else {
            val trigonometryVideo = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4")
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(trigonometryVideo)
        }

        videoView.requestFocus()
        videoView.start()

        backVideoButton.setOnClickListener {
            val intent = Intent(applicationContext, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}