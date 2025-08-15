package com.palestine.here

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import com.palestine.here.ui.theme.PalestineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            PalestineTheme {
                FreePalestineWebView()
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FreePalestineWebView() {
    val url = "https://free-palestine.flutterflow.app/?s=09"
    var isLoading by remember { mutableStateOf(true) }
    var webView by remember { mutableStateOf<WebView?>(null) }
    var canGoBack by remember { mutableStateOf(false) }
    
    // Handle back press
    BackHandler(enabled = canGoBack) {
        webView?.goBack()
    }
    
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // WebView using AndroidView
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    webView = this
                    
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                            isLoading = true
                        }
                        
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            isLoading = false
                            canGoBack = view?.canGoBack() ?: false
                        }
                        
                        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                            super.doUpdateVisitedHistory(view, url, isReload)
                            canGoBack = view?.canGoBack() ?: false
                        }
                    }
                    
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        loadWithOverviewMode = true
                        useWideViewPort = true
                        builtInZoomControls = true
                        displayZoomControls = false
                        setSupportZoom(true)
                        databaseEnabled = true
                        allowFileAccess = true
                        allowContentAccess = true
                        
                        // Enable caching for better performance
                        cacheMode = android.webkit.WebSettings.LOAD_DEFAULT
                        
                        // Support for mixed content (http and https)
                        mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                    }
                    
                    loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { view ->
                // Keep reference updated
                webView = view
            }
        )
        
        // Loading overlay
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
        
        // Progress bar at top
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                color = Color(0xFF007A3D), // Palestine green
                trackColor = Color(0xFFF1F4F9) // Same as system bars
            )
        }
    }
}