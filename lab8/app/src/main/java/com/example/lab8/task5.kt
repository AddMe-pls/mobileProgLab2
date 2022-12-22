package com.example.lab8

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class   task5 : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable: Runnable
    private var handler: Handler = Handler()
    private var pause: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5)

        val playBtn = findViewById<Button>(R.id.playBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)
        val pauseBtn = findViewById<Button>(R.id.pauseBtn)
        val seek_bar = findViewById<SeekBar>(R.id.seek_bar)
        val tv_pass = findViewById<TextView>(R.id.tv_pass)
        val tv_due = findViewById<TextView>(R.id.tv_due)

        playBtn.setOnClickListener {
            if (pause) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            } else {

                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.firstmusic)
                mediaPlayer.start()
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()

            }

            seek_bar.max = mediaPlayer.duration / 1000
            runnable = Runnable {
                seek_bar.progress = mediaPlayer.currentPosition / 1000

                tv_pass.text = "${mediaPlayer.currentPosition / 1000} sec"
                val diff = mediaPlayer.currentPosition / 1000 - mediaPlayer.duration / 1000
                tv_due.text = "$diff sec"

                handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)

            playBtn.isEnabled = false
            pauseBtn.isEnabled = true
            stopBtn.isEnabled = true

            mediaPlayer.setOnCompletionListener {
                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = false

                Toast.makeText(this, "end", Toast.LENGTH_SHORT).show()
            }
        }

        pauseBtn.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                pause = true
                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = true
                Toast.makeText(this,"media pause",Toast.LENGTH_SHORT).show()
            }
        }

        stopBtn.setOnClickListener{
            if(mediaPlayer.isPlaying || pause.equals(true)){
                pause = false
                seek_bar.setProgress(0)
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
                handler.removeCallbacks(runnable)

                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = false
                tv_pass.text = ""
                tv_due.text = ""
                Toast.makeText(this,"media stop",Toast.LENGTH_SHORT).show()
            }
        }

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) mediaPlayer.seekTo(p1 * 1000)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
    }
}