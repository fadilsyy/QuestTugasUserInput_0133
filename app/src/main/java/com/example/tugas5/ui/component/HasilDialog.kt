package com.example.tugas5.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.tugas5.R

@Composable
fun HasilDialog(
    namaDepan: String,
    namaBelakang: String,
    email: String,
    tglLahir: String,
    experience: String,
    minat: List<String>,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = colorResource(R.color.surface_form),
        title = { Text(text = stringResource(R.string.dialog_judul)) },
        text = {
            Text(
                text = stringResource(
                    R.string.dialog_isi,
                    namaDepan,
                    namaBelakang,
                    email,
                    tglLahir,
                    experience,
                    minat.joinToString(separator = stringResource(R.string.pemisah_minat))
                )
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(R.string.dialog_tutup))
            }
        }
    )
}