package com.example.myapplication

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myapplication.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private val binding: ActivityWebViewBinding by lazy {
        ActivityWebViewBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        setContentView(webView)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        // Get URL from intent
        val url = intent.getStringExtra("url") ?: "https://www.google.com"
        webView.loadUrl(url)
    }
}