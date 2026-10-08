package com.example.banderas.Screens

import androidx.compose.ui.graphics.Color
import com.example.banderas.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaAlemania(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Black)
        )
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(colorResource(id=R.color.Rojo_Aleman))
            )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.Amarillo_Aleman))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaAlemaniaPreview() {
    BANDERASTheme {
        BanderaAlemania()
    }
}