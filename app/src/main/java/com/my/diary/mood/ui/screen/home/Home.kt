package com.my.diary.mood.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.my.diary.mood.R
import com.my.diary.mood.ui.screen.home.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun Home() {
    val viewModel: HomeViewModel = getViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_what_is_your_mood),
            fontFamily = FontFamily.Default,
            style = MaterialTheme.typography.h6
        )
        Box(modifier = Modifier.weight(1f))

    }

}