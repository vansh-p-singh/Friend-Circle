package com.altrodav.friendcircle.learning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.PrimaryButton
import com.altrodav.friendcircle.db.FriendDatabase
import com.altrodav.friendcircle.db.FriendEntity
import com.altrodav.friendcircle.db.ProfileEntity
import kotlinx.coroutines.launch

@Composable
fun DBTest2() {
    var username by remember {
        mutableStateOf("")
    }
    var img by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val db = remember { FriendDatabase.getDatabase(context) }
    val dao = remember { db.friendDao() }
    val friends by dao.getAllFriends()
        .collectAsState(initial = emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
    OutlinedTextField(
        value = username,
        onValueChange = {
            username = it
        },
        label = {
            Text("Username")
        }
    )
    OutlinedTextField(
        value = name,
        onValueChange = {
            name = it
        },
        label = {
            Text("Name")
        }
    )
    OutlinedTextField(
        value = img,
        onValueChange = {
            img = it
        },
        label = {
            Text("Image")
        }
    )

//        Save Button
        PrimaryButton("Save", onClick = {
            scope.launch {

                val friend = FriendEntity(
                    name = name,
                    username = username,
                    img = img
                )

                dao.insertFriend(friend)
                name=""
                username=""
                img=""

            }
        }, modifier = Modifier.fillMaxWidth())

//        Display Friends
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(friends) { friend ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(friend.name)
                        Text(friend.username)
                        Text(friend.img)
                    }
                }
            }
        }
}
}