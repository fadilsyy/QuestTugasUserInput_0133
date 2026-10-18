package com.example.tugas5.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.tugas5.R
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldTanggalLahir(
    tanggal: String,
    onTanggalDipilih: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var tampilPicker by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    // Seluruh field bisa diketuk untuk membuka picker
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaksi ->
            if (interaksi is PressInteraction.Release) tampilPicker = true
        }
    }

    OutlinedTextField(
        value = tanggal,
        onValueChange = {},
        readOnly = true,
        singleLine = true,
        label = { Text(text = stringResource(R.string.label_tgl_lahir)) },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = stringResource(R.string.cd_pilih_tanggal)
            )
        },
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_field)),
        colors = warnaField(),
        interactionSource = interactionSource,
        modifier = modifier
    )

    if (tampilPicker) {
        val pickerState = rememberDatePickerState()
        val pola = stringResource(R.string.format_tanggal)

        DatePickerDialog(
            onDismissRequest = { tampilPicker = false },
            confirmButton = {
                TextButton(onClick = {
                    pickerState.selectedDateMillis?.let { millis ->
                        onTanggalDipilih(
                            Instant.ofEpochMilli(millis)
                                .atZone(ZoneOffset.UTC)
                                .toLocalDate()
                                .format(DateTimeFormatter.ofPattern(pola))
                        )
                    }
                    tampilPicker = false
                }) { Text(text = stringResource(R.string.dialog_ok)) }
            },
            dismissButton = {
                TextButton(onClick = { tampilPicker = false }) {
                    Text(text = stringResource(R.string.dialog_batal))
                }
            }
        ) {
            DatePicker(state = pickerState)
        }
    }
}