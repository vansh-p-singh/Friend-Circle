package com.altrodav.friendcircle.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun FeedCard(user:String,time:String,desc:String,img: String?){
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Text("@$user", style = MaterialTheme.typography.titleMedium)
                Text(time, style = MaterialTheme.typography.bodySmall)
            }
            if(img!=null){
                AsyncImage(img, contentDescription = "Post Image", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
            }
            Text(desc, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FeedCardPreview(){
    FriendCircleTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            FeedCard("vanshpsingh20", "2 Days Ago","They say a recipe has no soul, but the hands that prepare it certainly do. Cooking in a community setting transforms an ordinary Tuesday into a vibrant feast. We shared ingredients, swapped tips, and most importantly, we shared our time with one another. When you cook with love and from the heart, the result is never just a meal—it’s an experience.","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHh1t7FLkkIjmvm5PTpzg14WK5u6vArusCgUz2ol28vBu8B-ewKAt2zoCR&s=10")

        }
    }
}