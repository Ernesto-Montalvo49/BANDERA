package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaSuiza(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .background(colorResource(id = R.color.Rojo_Suiza))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.62f)
                .background(Color.White)
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.62f)
                .background(Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaPreview() {
    BANDERASTheme {
        BanderaSuiza(modifier = Modifier.fillMaxSize())
    }
}