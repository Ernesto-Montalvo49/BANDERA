package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaEEUUConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val cantonAzul = createRef()

        val guiaAnchoCanton = createGuidelineFromStart(0.40f)
        val guiaAltoCanton = createGuidelineFromTop(7f / 13f)

        for (i in 0 until 13) {
            val gTop = createGuidelineFromTop(i / 13f)
            val gBottom = createGuidelineFromTop((i + 1) / 13f)
            val refFranja = createRef()

            val colorFranja = if (i % 2 == 0) {
                colorResource(id = R.color.rojo_eeuu)
            } else {
                Color.White
            }

            Box(
                modifier = Modifier
                    .background(colorFranja)
                    .constrainAs(refFranja) {
                        top.linkTo(gTop)
                        bottom.linkTo(gBottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )
        }

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.azul_eeuu))
                .padding(vertical = 4.dp, horizontal = 2.dp)
                .constrainAs(cantonAzul) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guiaAltoCanton)
                    start.linkTo(parent.start)
                    end.linkTo(guiaAnchoCanton)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val patronEstrellas = listOf(6, 5, 6, 5, 6, 5, 6, 5, 6)
                for (cantidad in patronEstrellas) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(cantidad) {
                            Canvas(modifier = Modifier.size(7.dp)) {
                                val path = Path()
                                val radius = size.minDimension / 2f
                                val innerRadius = radius * 0.382f
                                val centerX = size.width / 2f
                                val centerY = size.height / 2f

                                for (j in 0 until 10) {
                                    val r = if (j % 2 == 0) radius else innerRadius
                                    val angle = j * PI / 5 - PI / 2
                                    val x = centerX + r * cos(angle).toFloat()
                                    val y = centerY + r * sin(angle).toFloat()

                                    if (j == 0) path.moveTo(x, y) else path.lineTo(x, y)
                                }
                                path.close()
                                drawPath(path = path, color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEEUUPreview() {
    BANDERASTheme {
        BanderaEEUUConstraint(modifier = Modifier.fillMaxSize())
    }
}