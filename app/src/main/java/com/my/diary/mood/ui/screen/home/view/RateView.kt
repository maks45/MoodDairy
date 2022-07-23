package com.my.diary.mood.ui.screen.home.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun RateView(
    modifier: Modifier = Modifier,
    @DrawableRes rateIcon: Int,
    rateColor: Color = Color.Yellow,
    onRateChange: (Int) -> Unit,
    rateRange: Int = 5
) {
    Row(modifier = modifier) {
        for (i in 0..rateRange) {
            Image(
                painter = painterResource(id = rateIcon),
                contentDescription = "rate icon"
            )
        }
    }
}