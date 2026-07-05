package com.altrodav.friendcircle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun WelcomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background).padding(25.dp), verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Logo
        Image(painter = painterResource(R.drawable.logo), contentDescription = "Logo", modifier = Modifier.size(100.dp))
        // Heading
        Text(text = "Welcome to Friend Circle",color= MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.headlineMedium)

        // Sub-Heading
        Text(text = "Friend Circle is a social, activity-first app: it helps people build circles of friends and meet up around real activities.", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
//        Follow-up Button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Get Started")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview(){
    FriendCircleTheme {
        WelcomeScreen()
    }
}