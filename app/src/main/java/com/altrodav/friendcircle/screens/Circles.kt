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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun Circles(navController: NavController){
    LazyColumn(
        modifier = Modifier.padding(5.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(friendsList){
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

data class Friend(val name:String,val img:String,val username:String);

val friendsList=listOf<Friend>(
    Friend("Reeta", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","reetaqueen123"),
    Friend("Seeta", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","seettaaaaaa"),
    Friend("Geeta", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","heyItsmeGeetu123"),
    Friend("Roshni", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","lightindark"),
    Friend("Rashmi", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","rashmee_32"),
    Friend("Aparna Thakur", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","thakurani23"),
    Friend("Drishti Paras", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","dishu_786"),
    Friend("Sakshi Rana", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","sakshirana123"),
    Friend("Ankita", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","heyyankuuuuu"),
    Friend("Azra Khan", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","queen_azru"),
    Friend("Angel Priya", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","priyuu_angel"),
    Friend("Mani Attri", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","mani.attri.34"),
    Friend("Harnoor Kaur", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","harnoor.987"),
    Friend("Jasmine Kaur", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","jass_kaur.4"),
    Friend("Amrita Saini", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","its.me.amrita"),
    Friend("Divya Kaushal", img = "https://static.vecteezy.com/system/resources/previews/001/609/739/non_2x/indian-girl-face-avatar-cartoon-free-vector.jpg","diva.divya")
)