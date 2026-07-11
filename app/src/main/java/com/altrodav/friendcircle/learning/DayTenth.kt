package com.altrodav.friendcircle.learning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.R

@Composable
fun LazyListTesting(){
    val FriendList=mutableListOf<Friend>(
        Friend(id = 1,"Vansh Pratap","21\n:Software Engineer\nLoves Reading & Cooking"),
        Friend(id = 2,"Ganesh Gaitone","22\n:Software Engineer\nLoves Travelling"),
        Friend(id = 3,"Hamza Ali Mazhari","40\n:Design Engineer\nLoves Painting"),
        Friend(id = 4,"Uzair Baloch","31\n:Finance Manager\nFootball"),
        Friend(id = 5,"Arjan Singh","19\t:Student\nMelophile"),Friend(id = 6, "Ayesha Khan", "24\n:Graphic Designer\nLoves Photography"),
        Friend(id = 7, "Rohan Mehta", "27\n:Android Developer\nLoves Gaming"),
        Friend(id = 8, "Priya Sharma", "23\n:Medical Student\nLoves Dancing"),
        Friend(id = 9, "Karan Verma", "29\n:Data Analyst\nLoves Cricket"),
        Friend(id = 10, "Neha Kapoor", "26\n:Content Writer\nLoves Reading"),
        Friend(id = 11, "Aditya Singh", "30\n:Software Engineer\nLoves Trekking"),
        Friend(id = 12, "Sara Ahmed", "22\n:UI/UX Designer\nLoves Sketching"),
        Friend(id = 13, "Rahul Joshi", "28\n:Civil Engineer\nLoves Cycling"),
        Friend(id = 14, "Meera Nair", "25\n:Teacher\nLoves Music"),
        Friend(id = 15, "Aman Gupta", "31\n:Entrepreneur\nLoves Fitness"),
        Friend(id = 16, "Simran Kaur", "21\n:Student\nLoves Painting"),
        Friend(id = 17, "Harsh Patel", "33\n:Chartered Accountant\nLoves Chess"),
        Friend(id = 18, "Fatima Noor", "24\n:Doctor\nLoves Cooking"),
        Friend(id = 19, "Nikhil Arora", "27\n:Cyber Security Analyst\nLoves Movies"),
        Friend(id = 20, "Ananya Das", "23\n:Software Tester\nLoves Blogging"),
        Friend(id = 21, "Dev Malhotra", "26\n:Cloud Engineer\nLoves Travelling")
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray).padding(top = 30.dp, start = 10.dp, end = 10.dp),verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        if(FriendList.isEmpty()){
            item {EmptyView()}
        }
        else {
            items(FriendList, key = { friend -> friend.id }) { friend ->
                FriendRow(friend);
            }
        }
    }
}

@Composable
fun FriendRow(friend: Friend){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(Color.White)
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically){
//        Icon/Avatar
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(Color.Gray)
            .size(96.dp)
            , contentAlignment = Alignment.Center){
            Image(painter = painterResource(R.drawable.default_avtar), contentDescription = "Profile Avatar", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
//        Spacing
        Spacer(modifier = Modifier.width(30.dp))
//        Content - Name and Description
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "${friend.name}", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSurface)
            Text(text = "${friend.bio}", style = MaterialTheme.typography.bodyMedium,color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
fun EmptyView(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Icon(Icons.Filled.Face, contentDescription = "No Friend", modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Your Friend List is Empty. Do add some friends and make some wonderful memories with them!", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLazyList(){
    LazyListTesting();
}

data class Friend(val id:Int,var name:String,var bio:String)