package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme
import androidx.compose.ui.graphics.Path
import kotlin.math.tan

@Composable
fun BanderaSeychelles(modifier : Modifier= Modifier){
    val azul= colorResource(id = R.color.Azul_Seychelles)
    val rojo = colorResource(id = R.color.Rojo_Seychelles)
    val verde = colorResource(id = R.color.Verde_Seychelles)
    val amarillo = colorResource(id = R.color.Amarillo_Seychelles)

    val colores = listOf(azul, amarillo, rojo, Color.White, verde)
    val angles = listOf(90f, 72f, 54f, 36f, 18f, 0f)

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val origin = Offset(0f, height)

        fun getBorderPoint(angleDegrees: Float): Offset {
            if (angleDegrees == 90f) return Offset(0f, 0f)
            if (angleDegrees == 0f) return Offset(width, height)

            val rad = Math.toRadians(angleDegrees.toDouble())
            val xCandidate = (height / tan(rad)).toFloat()

            return if (xCandidate <= width) {
                Offset(xCandidate, 0f)
            } else {
                val yCandidate = height - (width * tan(rad)).toFloat()
                Offset(width, yCandidate)
            }
        }

        for (i in 0 until 5) {
            val startAngle = angles[i]
            val endAngle = angles[i + 1]

            val pA = getBorderPoint(startAngle)
            val pB = getBorderPoint(endAngle)

            val path = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(pA.x, pA.y)

                if (pA.y == 0f && pB.x == width) {
                    lineTo(width, 0f)
                }

                lineTo(pB.x, pB.y)
                close()
            }

            drawPath(
                path = path,
                color = colores[i]
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview(){
    BANDERASTheme{
        BanderaSeychelles(modifier = Modifier.fillMaxSize())
    }
}