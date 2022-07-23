package com.my.diary.mood.ui.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.my.diary.mood.R
import com.my.diary.mood.ui.screen.home.data.MoodItemData
import com.my.diary.mood.ui.screen.home.data.MoodItemViewData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoodItemView(
    modifier: Modifier = Modifier,
    data: MoodItemViewData,
    onSave: (MoodItemData) -> Unit,
) {
    val expanded = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier,
        onClick = {
            expanded.value = !expanded.value
        },
        contentColor = MaterialTheme.colors.primaryVariant,
        elevation = 4.dp,
        shape = MaterialTheme.shapes.large,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            text = stringResource(id = R.string.home_mood_feel, stringResource(id = data.moodName)),
            style = MaterialTheme.typography.subtitle1
        )
    }
}
