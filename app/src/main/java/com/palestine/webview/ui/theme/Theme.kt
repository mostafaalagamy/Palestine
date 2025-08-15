package com.palestine.webview.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Palestine flag colors
private val PalestineGreen = Color(0xFF007A3D)
private val PalestineRed = Color(0xFFCE1126)
private val PalestineBlack = Color(0xFF000000)
private val PalestineWhite = Color(0xFFFFFFFF)

private val DarkColorScheme = darkColorScheme(
    primary = PalestineGreen,
    onPrimary = PalestineWhite,
    primaryContainer = Color(0xFF005228),
    onPrimaryContainer = Color(0xFF90F4B8),
    secondary = PalestineRed,
    onSecondary = PalestineWhite,
    secondaryContainer = Color(0xFF930018),
    onSecondaryContainer = Color(0xFFFFDAD6),
    tertiary = Color(0xFF4FD8EB),
    onTertiary = Color(0xFF00363D),
    tertiaryContainer = Color(0xFF004F58),
    onTertiaryContainer = Color(0xFF97F0FF),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE2E2E6),
    surface = Color(0xFF1A1C1E),
    onSurface = Color(0xFFE2E2E6),
    surfaceVariant = Color(0xFF414941),
    onSurfaceVariant = Color(0xFFC1C9BE),
    outline = Color(0xFF8B938A),
    inverseOnSurface = Color(0xFF1A1C1E),
    inverseSurface = Color(0xFFE2E2E6),
    inversePrimary = PalestineGreen,
    surfaceTint = Color(0xFF6FDB92),
)

private val LightColorScheme = lightColorScheme(
    primary = PalestineGreen,
    onPrimary = PalestineWhite,
    primaryContainer = Color(0xFFA7F5C8),
    onPrimaryContainer = Color(0xFF002109),
    secondary = PalestineRed,
    onSecondary = PalestineWhite,
    secondaryContainer = Color(0xFFFFDAD6),
    onSecondaryContainer = Color(0xFF410002),
    tertiary = Color(0xFF006874),
    onTertiary = PalestineWhite,
    tertiaryContainer = Color(0xFF97F0FF),
    onTertiaryContainer = Color(0xFF001F24),
    error = Color(0xFFBA1A1A),
    onError = PalestineWhite,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFFCFDF6),
    onBackground = Color(0xFF1A1C1A),
    surface = Color(0xFFFCFDF6),
    onSurface = Color(0xFF1A1C1A),
    surfaceVariant = Color(0xFFDDE5DA),
    onSurfaceVariant = Color(0xFF414941),
    outline = Color(0xFF717970),
    inverseOnSurface = Color(0xFFF0F1EB),
    inverseSurface = Color(0xFF2F312E),
    inversePrimary = Color(0xFF6FDB92),
    surfaceTint = PalestineGreen,
)

@Composable
fun PalestineTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Make status bar and navigation bar transparent
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            
            // Set light/dark icons based on theme
            val windowInsetsController = WindowCompat.getInsetsController(window, view)
            windowInsetsController.isAppearanceLightStatusBars = !darkTheme
            windowInsetsController.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}