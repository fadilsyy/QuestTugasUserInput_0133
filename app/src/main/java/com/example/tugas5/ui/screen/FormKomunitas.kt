package com.example.tugas5.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.tugas5.R
import com.example.tugas5.ui.component.FieldExperience
import com.example.tugas5.ui.component.FieldTanggalLahir
import com.example.tugas5.ui.component.FieldTeks
import com.example.tugas5.ui.component.HasilDialog
import com.example.tugas5.ui.component.PilihanMinat

@Composable
fun FormKomunitas(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    val daftarExperience = stringArrayResource(R.array.pilihan_experience).toList()
    val minatTerpilih = remember { mutableStateListOf<String>() }
    val daftarMinat = stringArrayResource(R.array.pilihan_minat).toList()
    var tampilHasil by remember { mutableStateOf(false) }
    val formLengkap = namaDepan.isNotBlank() && namaBelakang.isNotBlank() &&
            email.isNotBlank() && tglLahir.isNotBlank() &&
            experience.isNotBlank() && minatTerpilih.isNotEmpty()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(R.dimen.padding_form)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.form_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_title)))
        Text(
            text = stringResource(R.string.form_subtitle),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.text_secondary)
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_section)))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_field))
        ) {
            FieldTeks(
                value = namaDepan,
                onValueChange = { namaDepan = it },
                label = stringResource(R.string.label_nama_depan),
                modifier = Modifier.weight(1f)
            )
            FieldTeks(
                value = namaBelakang,
                onValueChange = { namaBelakang = it },
                label = stringResource(R.string.label_nama_belakang),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_field)))

        FieldTeks(
            value = email,
            onValueChange = { email = it },
            label = stringResource(R.string.label_email),
            keyboardType = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_field)))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_field))
        ) {
            FieldTanggalLahir(
                tanggal = tglLahir,
                onTanggalDipilih = { tglLahir = it },
                modifier = Modifier.weight(1f)
            )
            FieldExperience(
                pilihan = daftarExperience,
                terpilih = experience,
                onPilih = { experience = it },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_section)))

        Text(
            text = stringResource(R.string.label_minat),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.text_primary),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_small)))
        PilihanMinat(
            daftarMinat = daftarMinat,
            terpilih = minatTerpilih,
            onToggle = { minat ->
                if (minat in minatTerpilih) minatTerpilih.remove(minat)
                else minatTerpilih.add(minat)
            }
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.spacing_section)))

        Button(
            onClick = { tampilHasil = true },
            enabled = formLengkap,
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_button)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = colorResource(R.color.button_text),
                disabledContainerColor = colorResource(R.color.button_disabled_bg),
                disabledContentColor = colorResource(R.color.button_disabled_text)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.button_height))
        ) {
            Text(
                text = stringResource(R.string.tombol_daftar),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }

        if (tampilHasil) {
            HasilDialog(
                namaDepan = namaDepan,
                namaBelakang = namaBelakang,
                email = email,
                tglLahir = tglLahir,
                experience = experience,
                minat = minatTerpilih,
                onDismiss = { tampilHasil = false }
            )
        }
    }
}