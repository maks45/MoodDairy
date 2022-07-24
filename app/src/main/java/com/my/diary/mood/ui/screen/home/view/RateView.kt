package com.my.diary.mood.ui.screen.home.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.my.diary.mood.R
import kotlin.math.roundToInt

@Composable
fun RateView(
    modifier: Modifier = Modifier,
    @DrawableRes rateIcon: Int = R.drawable.ic_star_mask,
    rateColor: Color = Color.Cyan,
    onRateChange: (Int) -> Unit,
    rateIconSize: Int = 25,
    rateRange: Int = 5
) {
    val width = (rateIconSize * rateRange).dp
    val clickOffset = remember {
        mutableStateOf(0f)
    }
    val widgetWidth = remember { mutableStateOf(0) }
    val currentRate = remember { mutableStateOf(0f) }


    Box(modifier = modifier
        .width((rateIconSize * rateRange).dp)
        .onGloballyPositioned {
            widgetWidth.value = it.size.width
        }
        .pointerInput(Unit) {
            detectTapGestures { offset ->
                val rate = ((offset.x / widgetWidth.value) * rateRange)
                    .roundToInt()
                onRateChange.invoke(rate)
                currentRate.value = rate / rateRange.toFloat()
            }
        }) {
        Row {
            Box(
                modifier = Modifier
                    .background(color = rateColor)
                    .height(rateIconSize.dp)
                    .fillMaxWidth(currentRate.value)
            )
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .height(rateIconSize.dp)
                    .weight(1f)
            )
        }
        Row {
            for (i in 1..rateRange) {
                Image(
                    modifier = Modifier.size(rateIconSize.dp),
                    painter = painterResource(id = rateIcon),
                    contentDescription = "rate icon"
                )
            }
        }
    }
}