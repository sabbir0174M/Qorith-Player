package com.qorithone.qorith.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1976E0),
    secondary = Color(0xFF39C0F2),
    tertiary = Color(0xFF0B1B3F),
    background = Color(0xFF000000),
    surface = Color(0xFF10182A),
    error = Color(0xFFE0517E)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0F4FA8),
    secondary = Color(0xFF39C0F2),
    tertiary = Color(0xFF0B1B3F),
    background = Color(0xFFF4F6FA),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFE0517E)
)

@Composable
fun QorithTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = QorithTypography,
        content = content
    )
}
