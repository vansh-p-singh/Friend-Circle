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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altrodav.friendcircle.PrimaryButton
import com.altrodav.friendcircle.components.ProfileHeader
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme
import com.altrodav.friendcircle.viewmodels.ProfileViewModel

@Composable
fun ProfileScreen(navController: NavController){
    val viewModel: ProfileViewModel=viewModel();
    val uiState by viewModel.uiState.collectAsStateWithLifecycle();
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), horizontalAlignment = Alignment.CenterHorizontally){
            ProfileHeader(name = uiState.name, bio = uiState.bio)
        Column {
            OutlinedTextField(value = viewModel.bioInput, onValueChange = {
                viewModel.updateBioInput(it)
            }, label = {
                Text("Bio")
            }, modifier = Modifier.padding(5.dp).fillMaxWidth().defaultMinSize(minHeight = 100.dp))
            PrimaryButton("Update Bio", onClick = {
                viewModel.updateBio()
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