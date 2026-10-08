package com.example.banderas.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaEspanaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (caja1, caja2, caja3, escudo_espana) = createRefs()
        val linea1 = createGuidelineFromTop(0.25f)
        val linea2 = createGuidelineFromTop(0.75f)

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.rojo_espana))
                .constrainAs(caja1) {
                    top.linkTo(parent.top)
                    bottom.linkTo(linea1)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.amarillo_espana))
                .constrainAs(caja2) {
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.rojo_espana))
                .constrainAs(caja3) {
                    top.linkTo(linea2)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Image(
            painter = painterResource(id= R.drawable.escudo_espana),
            contentDescription = "Escudo_Espana",
            modifier=Modifier
                .size(200.dp)
                .constrainAs(escudo_espana){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    var horizontalBias=0.2f
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEspanaPreview() {
    BANDERASTheme {
        BanderaEspanaConstraint(modifier = Modifier.fillMaxSize())
    }
}