package com.example.tugas5.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PilihanMinat(
    daftarMinat: List<String>,
    terpilih: List<String>,
    onToggle: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        daftarMinat.forEach { minat ->
            MinatItem(
                label = minat,
                dipilih = minat in terpilih,
                onToggle = { onToggle(minat) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}