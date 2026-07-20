package com.altrodav.friendcircle.learning

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FriendListScreen(viewModel: FriendViewModel){
    var searchQuery by remember{
        mutableStateOf("");
    }
    val filteredFriends by viewModel.filteredFriends.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value=searchQuery,
            onValueChange = {
                searchQuery=it
                viewModel.updateSearchQuery(it)
            },
            label = {
                Text("Search for Friend")
            }, modifier = Modifier.fillMaxWidth().padding(5.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(filteredFriends){
                item->
                Text(item.name)
            }

            }
        }
    }

@Preview(showSystemUi = true)
@Composable
fun FriendListScreenPreview(){
    val viewModel: FriendViewModel = viewModel()
    FriendListScreen(viewModel)
}

