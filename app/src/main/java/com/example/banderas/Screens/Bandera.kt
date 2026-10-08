package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.banderas.R
import com.example.banderas.ui.theme.BANDERASTheme

@Composable
fun BanderaJaponConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (sol) = createRefs()

        Box(
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.rojo_japon))
                .constrainAs(sol) {
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
fun BanderaJaponPreview() {
    BANDERASTheme {
        BanderaJaponConstraint(modifier = Modifier.fillMaxSize())
    }
}