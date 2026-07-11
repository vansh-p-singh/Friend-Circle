package com.altrodav.friendcircle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun WelcomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background).padding(25.dp), verticalArrangement = Arrangement.spacedBy(25.dp, alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Heading
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome to",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W400,
                color= MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Friend Circle",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        //Logo
        Image(painter = painterResource(R.drawable.logo), contentDescription = "Logo", modifier = Modifier.size(150.dp))

        // Sub-Heading
        Text(text = "We help people build circles of friends and meet up around real activities.", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
//        Follow-up Button
        PrimaryButton(text = "Get Started", onClick = {}, modifier = Modifier.fillMaxWidth());
    }

}

// Resuable Primary Button
@Composable
fun PrimaryButton(text:String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(modifier=modifier, onClick = onClick) {
        Text(text, style = MaterialTheme.typography.titleMedium)
    }
    }


@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview(){
    FriendCircleTheme {
        WelcomeScreen()
    }
}