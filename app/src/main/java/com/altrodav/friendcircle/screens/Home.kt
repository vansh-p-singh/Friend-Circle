package com.altrodav.friendcircle.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.components.FeedCard
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun Home(){

    LazyColumn(
        modifier = Modifier.padding(5.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listPost){
            item->
            FeedCard(item.user,item.time,item.desc,item.img)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHome(){
    FriendCircleTheme {
        Home()
    }
}

data class Post(val user:String,val time:String,val desc:String,val img:String?)

val listPost=listOf(
    Post("vanshpsingh20", "2 Days Ago","They say a recipe has no soul, but the hands that prepare it certainly do. Cooking in a community setting transforms an ordinary Tuesday into a vibrant feast. We shared ingredients, swapped tips, and most importantly, we shared our time with one","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHh1t7FLkkIjmvm5PTpzg14WK5u6vArusCgUz2ol28vBu8B-ewKAt2zoCR&s=10"),
    Post("ranjan20","3 Days Ago","I would rather walk with a friend in the dark, than alone in the light Southern Living.", img = "https://thumbs.dreamstime.com/b/diversity-friends-friendship-team-community-concept-68793776.jpg"),
    Post("rockyBhai45","1 Hour Ago","Looking to make new friends in the city", null),

)