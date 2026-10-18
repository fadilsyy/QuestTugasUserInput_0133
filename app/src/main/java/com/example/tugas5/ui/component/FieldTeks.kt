package com.example.tugas5.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.tugas5.R

@Composable
fun FieldTeks(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = label) },
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_field)),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = warnaField(),
        modifier = modifier
    )
}

@Composable
fun warnaField() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = MaterialTheme.colorScheme.primary,
    unfocusedBorderColor = colorResource(R.color.field_border),
    focusedLabelColor = MaterialTheme.colorScheme.primary,
    unfocusedLabelColor = colorResource(R.color.field_label)
)