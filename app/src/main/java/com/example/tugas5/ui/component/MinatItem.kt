package com.example.tugas5.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import com.example.tugas5.R

@Composable
fun MinatItem(
    label: String,
    dipilih: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.toggleable(
            value = dipilih,
            onValueChange = { onToggle() },
            role = Role.Checkbox
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = dipilih,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = colorResource(R.color.field_border)
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = colorResource(R.color.text_primary)
        )
    }
}