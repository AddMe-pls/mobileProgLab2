package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class task7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task7)

        val webView = findViewById<WebView>(R.id.webview)
        webView.loadUrl("https://habr.com/ru/all/")
    }
}