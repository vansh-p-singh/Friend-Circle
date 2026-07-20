package com.altrodav.friendcircle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.altrodav.friendcircle.db.FriendDatabase
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun Circles(navController: NavController){
    val context = LocalContext.current
    val db = remember { FriendDatabase.getDatabase(context) }
    val dao = remember { db.friendDao() }

    val friends by dao.getAllFriends()
        .collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier.padding(5.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(friends){
                item->
            FriendCard(item.name,item.img,item.username)
        }
    }
}

@Composable
fun FriendCard(name: String, img: String, username: String){
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(Color.Red)){
                AsyncImage(img, contentDescription = "Profile Image", modifier = Modifier.fillMaxSize().clip(CircleShape), contentScale = ContentScale.FillBounds)
            }
            Column {
                Text(name, style = MaterialTheme.typography.titleMedium)
                Text("@$username", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
