package com.example.tugas5.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.tugas5.R

@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.header_komunitas),
        contentDescription = stringResource(R.string.cd_header),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.header_height))
    )
}