package com.example.banderas.Screens

import com.example.banderas.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.ui.theme.BANDERASTheme


@Composable
fun BanderaMexico(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(
                    colorResource(id=R.color.Verde_Mexico))
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudo_mexico),
                contentDescription = "Escudo nacional",
                modifier = Modifier.size(170.dp)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(colorResource(id=R.color.Rojo_Mexico))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaMexicoPreview() {
    BANDERASTheme {
        BanderaMexico()
    }
}