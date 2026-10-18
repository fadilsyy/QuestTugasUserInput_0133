package com.example.tugas5.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import com.example.tugas5.ui.component.HeaderImage

@Composable
fun FormKomunitasScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val bentukForm = RoundedCornerShape(dimensionResource(R.dimen.corner_form))   // ← BARU (1)

    Box(modifier = modifier.fillMaxSize()) {
        ->
        HeaderImage(modifier = Modifier.align(Alignment.TopCenter))

        Box(                                                                       // ← BARU (2)
            modifier = Modifier                                                    // ← BARU (2)
                .fillMaxSize()
                .padding(
                    top = dimensionResource(R.dimen.form_top_offset),
                    bottom = innerPadding.calculateBottomPadding() +
                            dimensionResource(R.dimen.form_bottom_margin)
                )
                .shadow(
                    elevation = dimensionResource(R.dimen.elevation_form),
                    shape = bentukForm
                )
                .background(
                    color = colorResource(R.color.surface_form),
                    shape = bentukForm
                )
        ) {
        }
    }
}