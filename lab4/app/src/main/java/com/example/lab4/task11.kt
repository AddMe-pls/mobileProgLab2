package com.example.lab4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService


class task11 : AppCompatActivity() {
    private val CHANNEL_ID = "channel_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task11)

        createNotificationChannel()

        findViewById<Button>(R.id.button_notif).setOnClickListener {
            val intent = Intent(this, NotificationService::class.java)
            intent.action = "start"
            startService(intent)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Notification title",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notification descr"
            }
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

class NotificationService : Service() {
    private var counter = 0
    private val CHANNEL_ID = "channel_id"
    private val notificationId = 101
    private lateinit var builder: NotificationCompat.Builder

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun sendNotification() {
        val intent1 = Intent(this, NotificationService::class.java)
        intent1.action = "reset"
        val intent2 = Intent(this, NotificationService::class.java)
        intent2.action = "add"

        builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Counter")
            .setContentText("$counter")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(0, "Reset", PendingIntent.getService(this, 0, intent1, PendingIntent.FLAG_IMMUTABLE))
            .addAction(0, "Add", PendingIntent.getService(this, 1, intent2, PendingIntent.FLAG_IMMUTABLE))

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }

    private fun apdateNotification() {
        builder.setContentText("$counter")
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action) {
            "start" -> {
                sendNotification()
            }
            "add" -> {
                counter++
                apdateNotification()
            }
            "reset" -> {
                counter = 0
                apdateNotification()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

}