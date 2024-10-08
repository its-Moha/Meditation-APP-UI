package com.example.meditationappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationappui.ui.theme.DeepBlue

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier

            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column{
            GreetingSection()

        }
    }
}

@Composable
fun GreetingSection(
    name:String = "Ghadkaawi"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
        ){
            Text("Good Morning, $name",
                style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.padding(8.dp))
            Text("Good Morning, Mr:$name",
                style = MaterialTheme.typography.bodyLarge)
        }
        Icon(
            painter = painterResource(id= R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
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
            GreetingSection()

        }

    }

}

