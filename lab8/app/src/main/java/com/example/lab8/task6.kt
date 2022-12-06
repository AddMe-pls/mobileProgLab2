package com.example.lab8

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class task6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task6)

        val videoView = findViewById<VideoView>(R.id.video_view)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val offlineUrl = Uri.parse("android.resource://com.example.lab8/" + R.raw.big_buck_bunny)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offlineUrl)
        videoView.requestFocus()
        videoView.start()
    }
}