package com.altrodav.friendcircle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme
import coil.compose.AsyncImage
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FriendCircleTheme {
                Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    AsyncImage(
                        model = "https://www.pngitem.com/pimgs/m/13-132003_android-robot-sideview-character-android-tutorial-hd-png.png",
                        contentDescription = "Test Image Loading"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Friend Circle",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FriendCircleTheme {
        Greeting();
    }
}