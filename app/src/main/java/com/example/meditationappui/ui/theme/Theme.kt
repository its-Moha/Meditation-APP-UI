package com.example.meditationappui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun MeditationAppUITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        shapes = shape,
        typography = Typography,
        content = content
    )
}