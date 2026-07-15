package com.altrodav.friendcircle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altrodav.friendcircle.PrimaryButton
import com.altrodav.friendcircle.components.ProfileHeader
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun ProfileScreen(navController: NavController){
    var bio by remember {
        mutableStateOf("21\t:Software Engineer\nLoves Reading & Cooking")
    }
    var bioInput by remember {
        mutableStateOf("21\t:Software Engineer\nLoves Reading & Cooking")
    }
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), horizontalAlignment = Alignment.CenterHorizontally){
        ProfileHeader(name = "Vansh Pratap", bio = bio)
        Column {
            OutlinedTextField(value = bioInput, onValueChange = {
                bioInput=it
            }, label = {
                Text("Bio")
            }, modifier = Modifier.padding(5.dp).fillMaxWidth().defaultMinSize(minHeight = 100.dp))
            PrimaryButton("Update Bio", onClick = {
                bio=bioInput
            }, modifier = Modifier.padding(5.dp).fillMaxWidth())
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewProfile(){
    FriendCircleTheme {
        ProfileScreen(navController = rememberNavController())
    }
}