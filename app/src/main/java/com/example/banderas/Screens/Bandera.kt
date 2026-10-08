package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

val RomboShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}

@Composable
fun BanderaBrasilConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.verde_brasil))
    ) {
        val (rombo, circulo) = createRefs()

        Box(
            modifier = Modifier
                .size(width = 340.dp, height = 220.dp)
                .clip(RomboShape)
                .background(colorResource(id = R.color.amarillo_brasil))
                .constrainAs(rombo) {
                    linkTo(start = parent.start, end = parent.end, bias = 0.5f)
                    linkTo(top = parent.top, bottom = parent.bottom, bias = 0.5f)
                }
        )

        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.azul_brasil))
                .constrainAs(circulo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaBrasilPreview() {
    BANDERASTheme {
        BanderaBrasilConstraint(modifier = Modifier.fillMaxSize())
    }
}