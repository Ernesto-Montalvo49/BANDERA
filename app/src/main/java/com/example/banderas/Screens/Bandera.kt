package com.example.banderas.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaEspana(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.Rojo_Espana))
        )

        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.Amarillo_Espana)),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudo_espana),
                contentDescription = "Escudo de España",
                modifier = Modifier
                    .padding(start = 40.dp)
                    .size(200.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.Rojo_Espana))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEspanaPreview() {
    BANDERASTheme {
        BanderaEspana()
    }
}