package com.my.diary.mood.ui.screen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.my.diary.mood.R
import com.my.diary.mood.data.MoodType
import com.my.diary.mood.data.mapToViewData
import com.my.diary.mood.ui.screen.home.HomeViewModel
import com.my.diary.mood.ui.screen.home.MoodItemView
import org.koin.androidx.compose.getViewModel

@Composable
fun Home() {
    val viewModel: HomeViewModel = getViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = 32.dp,
                horizontal = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_what_do_you_feel),
            fontFamily = FontFamily.Default,
            style = MaterialTheme.typography.h6
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 24.dp, bottom = 40.dp)
                .verticalScroll(
                    state = rememberScrollState(),
                )
        ) {
            MoodType.values()
                .map { it.mapToViewData() }
                .forEach { data ->
                    MoodItemView(
                        modifier = Modifier.padding(all = 8.dp),
                        data = data,
                        onSave = { viewModel.addMoodItem(it) }
                    )
                }
        }
    }

}