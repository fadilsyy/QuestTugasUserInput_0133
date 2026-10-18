package com.example.tugas5.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.tugas5.R

@Composable
fun Tugas5Theme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = colorResource(R.color.purple_primary),
        onPrimary = colorResource(R.color.button_text),
        background = colorResource(R.color.scaffold_bg),
        surface = colorResource(R.color.surface_form),
        onSurface = colorResource(R.color.text_primary)
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}