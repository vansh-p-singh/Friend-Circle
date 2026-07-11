package com.altrodav.friendcircle.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = OnPrimary,

    secondary = Pink80,
    onSecondary = OnSecondary,

    tertiary = Coral80,

    background = DarkBackground,
    onBackground = OnBackground,

    surface = DarkSurface,
    onSurface = OnSurface,

    outline = OutlineDark
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFA13AD6),
    onPrimary=Color(0xFFFFFFFF),
    secondary = Color(0xFFE64AA6),
    tertiary = Color(0xFFFF6B8A),
    onSurface = Color(0xFF1B1B1F),
    background = Color(color = 0xFFFFF8FD),
    surface=Color(0xFFFFFFFF),
    onBackground=Color(0xFF2D2D30),
    outline=Color(0xFFC8B7D6)
)

@Composable
fun FriendCircleTheme(
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}