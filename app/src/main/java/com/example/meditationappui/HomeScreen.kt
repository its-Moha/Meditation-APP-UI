package com.example.meditationappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationappui.ui.theme.AquaBlue
import com.example.meditationappui.ui.theme.Beige1
import com.example.meditationappui.ui.theme.BlueViolet1
import com.example.meditationappui.ui.theme.ButtonBlue
import com.example.meditationappui.ui.theme.DarkerButtonBlue
import com.example.meditationappui.ui.theme.DeepBlue
import com.example.meditationappui.ui.theme.LightGreen1
import com.example.meditationappui.ui.theme.LightRed
import com.example.meditationappui.ui.theme.OrangeYellow1
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
            FeatureSection(features = listOf(
                Feature(
                title = "Sleep Meditation",
                R.drawable.ic_headphone,
                BlueViolet1
                ),
                Feature(
                    title = "Tips for Sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_headphone,
                    OrangeYellow1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_videocam,
                    Beige1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_headphone,
                    OrangeYellow1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_videocam,
                    Beige1
                )
                ))
        }

        BottomMenu(items = listOf(
                BottomMenuContent("Home",R.drawable.ic_home),
                BottomMenuContent("Meditate",R.drawable.ic_bubble),
                BottomMenuContent("Sleep",R.drawable.ic_moon),
                BottomMenuContent("Music",R.drawable.ic_music),
                BottomMenuContent("Profile",R.drawable.ic_profile),
        ),
            modifier = Modifier.align(Alignment.BottomCenter))

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

@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            "Featured",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    Box(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f) // the width between two columns
            .clip(RoundedCornerShape(10.dp))
            .background(feature.color)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp, //if there is a line wrap we need a space between the 2 words
                modifier = Modifier.align(Alignment.TopStart)
                )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //handle what click button do
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(horizontal = 6.dp, vertical = 15.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items:List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor: Color = DeepBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex:Int = 0) {

    var selectedItemIndex by remember {
        mutableIntStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor

            ) {
                selectedItemIndex = index
            }
        }

    }


}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighLightColor: Color = DeepBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent )
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
                )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)

    ) {
        Column{
            GreetingsSection()
            ChipsSection(chips = listOf("SweetSleep","Insomnia","Depression","Mindfulness","Calmness","Focus"))
            CurrentMeditation()
            FeatureSection(features = listOf(
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1
                ),
                Feature(
                    title = "Tips for Sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_headphone,
                    OrangeYellow1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_videocam,
                    Beige1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_headphone,
                    BlueViolet1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_videocam,
                    LightGreen1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_headphone,
                    OrangeYellow1
                ),
                Feature(
                    title = "Night Island",
                    R.drawable.ic_videocam,
                    Beige1
                )
            ))
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home",R.drawable.ic_home),
            BottomMenuContent("Meditate",R.drawable.ic_bubble),
            BottomMenuContent("Sleep",R.drawable.ic_moon),
            BottomMenuContent("Music",R.drawable.ic_music),
            BottomMenuContent("Profile",R.drawable.ic_profile),
        ),
            modifier = Modifier.align(Alignment.BottomCenter))
    }


}

