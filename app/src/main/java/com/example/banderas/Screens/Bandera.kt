package com.example.banderas.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaArgentinaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (caja1, caja2, caja3, sol_de_mayo) = createRefs()
        val linea1 = createGuidelineFromTop(0.333f)
        val linea2 = createGuidelineFromTop(0.666f)

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.celeste_argentina))
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
                .background(Color.White)
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
                .background(colorResource(id = R.color.celeste_argentina))
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
            painter = painterResource(id = R.drawable.sol_de_mayo),
            contentDescription = "Sol de Mayo",
            modifier = Modifier
                .size(280.dp)
                .constrainAs(sol_de_mayo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaArgentinaPreview() {
    BANDERASTheme {
        BanderaArgentinaConstraint(modifier = Modifier.fillMaxSize())
    }
}