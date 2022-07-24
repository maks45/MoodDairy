package com.my.diary.mood.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.my.diary.mood.R
import com.my.diary.mood.ui.screen.home.data.MoodItemData
import com.my.diary.mood.ui.screen.home.data.MoodItemViewData
import com.my.diary.mood.ui.screen.home.data.mapToMoodType
import com.my.diary.mood.ui.screen.home.view.RateView

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoodItemView(
    modifier: Modifier = Modifier,
    data: MoodItemViewData,
    expanded: Boolean,
    onItemClick: () -> Unit,
    onSave: (MoodItemData) -> Unit,
) {
    val description = remember {
        mutableStateOf("")
    }
    val rate = remember {
        mutableStateOf(4)
    }
    val saveButtonActive = derivedStateOf {
        rate.value >= 0 && description.value.isNotBlank()
    }
    Box(modifier = modifier) {
        if (expanded) {
            Column(
                Modifier
                    .clip(shape = MaterialTheme.shapes.large)
                    .padding(all = 8.dp)
                    .background(MaterialTheme.colors.background)
            ) {
                Text(
                    modifier = modifier.padding(top = 60.dp),
                    text = stringResource(id = R.string.home_describe),
                    style = MaterialTheme.typography.subtitle2
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 100.dp),
                    value = description.value,
                    onValueChange = {
                        description.value = it
                    }
                )
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    RateView(onRateChange = {})
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    if (saveButtonActive.value) {
                        Image(
                            modifier = Modifier
                                .clickable {
                                    val item = MoodItemData(
                                        description = description.value,
                                        rate = rate.value,
                                        type = data.mapToMoodType()
                                    )
                                    onSave.invoke(item)
                                },
                            painter = painterResource(id = R.drawable.ic_baseline_check_24),
                            contentDescription = "save button"
                        )
                    }
                }
            }
        }
        Card(
            onClick = {
                onItemClick.invoke()
            },
            contentColor = MaterialTheme.colors.primaryVariant,
            elevation = 4.dp,
            shape = MaterialTheme.shapes.large,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                text = stringResource(
                    id = R.string.home_mood_feel,
                    stringResource(id = data.moodName)
                ),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}
