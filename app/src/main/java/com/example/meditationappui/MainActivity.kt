package com.example.meditationappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.meditationappui.ui.theme.MeditationAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeditationAppUITheme {

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}