package com.altrodav.friendcircle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.altrodav.friendcircle.components.ProfileHeader
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun ProfileScreen(navController: NavController,id:String?){
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)){
        ProfileHeader(name = "Vansh Pratap", bio = "21\t:Software Engineer\nLoves Reading & Cooking")
    }
}