package com.altrodav.friendcircle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
    ) {
        Text(text = "Welcome to Friend Circle",fontSize = 24.sp)
        Text(text = "Friend Circle is a social, activity-first app: it helps people build circles of friends and meet up around real activities.", fontSize = 16.sp, textAlign = TextAlign.Center)
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Magenta
            )
        ) {
            Text("Get Started")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen()
}