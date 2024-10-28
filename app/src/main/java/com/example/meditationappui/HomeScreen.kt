package com.example.meditationappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationappui.ui.theme.ButtonBlue
import com.example.meditationappui.ui.theme.DarkerButtonBlue
import com.example.meditationappui.ui.theme.DeepBlue
import com.example.meditationappui.ui.theme.LightRed
import com.example.meditationappui.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier


            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column{
            GreetingsSection()
            ChipsSection(chips = listOf("SweetSleep","Insomnia","Depression","Mindfulness","Calmness","Focus"))
            CurrentMeditation()
        }
    }
}

@Composable
fun GreetingsSection(
    name:String = "Gadhkaawi"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(

            verticalArrangement = Arrangement.Center
        ) {
            Text("Good Morning, Mr: $name",
                style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.padding(1.6.dp))

            Text("We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge)
        }

        Icon(painterResource(id = R.drawable.ic_search),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable {

                }
        )
    }
}


@Composable
fun ChipsSection(
    chips:List<String>
) {
    var selectedChip by remember {
        mutableIntStateOf(0)
    }

    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChip == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp) // padding the text inside the chip
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Column {
            Text(
                "Daily Thought",
                style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.padding(1.5.dp))
            Text(
                "Meditation . 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
    
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column{
            GreetingsSection()
            ChipsSection(chips = listOf("SweetSleep","Insomnia","Depression","Mindfulness","Calmness","Focus"))
            CurrentMeditation()
        }

    }

}

