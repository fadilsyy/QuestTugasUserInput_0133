package com.example.tugas5.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.tugas5.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldExperience(
    pilihan: List<String>,
    terpilih: String,
    onPilih: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var terbuka by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = terbuka,
        onExpandedChange = { terbuka = it },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = terpilih,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            label = { Text(text = stringResource(R.string.label_experience)) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = terbuka) },
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_field)),
            colors = warnaField(),
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = terbuka,
            onDismissRequest = { terbuka = false }
        ) {
            pilihan.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onPilih(item)
                        terbuka = false
                    }
                )
            }
        }
    }
}