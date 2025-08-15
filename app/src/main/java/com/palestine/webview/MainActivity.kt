package com.palestine.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.palestine.webview.ui.theme.PalestineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PalestineTheme {
                FreePalestineWebView()
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreePalestineWebView() {
    val url = "https://free-palestine.flutterflow.app/?s=09"
    var isLoading by remember { mutableStateOf(true) }
    var progress by remember { mutableStateOf(0) }
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Free Palestine 🇵🇸",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {
                    if (isLoading) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // WebView using AndroidView
            AndroidView(
                factory = { context ->
                    WebView(context).apply {
                        webViewClient = object : WebViewClient() {
                            override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                                super.onPageStarted(view, url, favicon)
                                isLoading = true
                            }
                            
                            override fun onPageFinished(view: WebView?, url: String?) {
                                super.onPageFinished(view, url)
                                isLoading = false
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
                        }
                        
                        loadUrl(url)
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
            
            // Loading overlay
            if (isLoading && progress < 100) {
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
        }
        
        // Progress bar at top
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}