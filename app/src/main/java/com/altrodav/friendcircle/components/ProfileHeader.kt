package com.altrodav.friendcircle.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.altrodav.friendcircle.R
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme

@Composable
fun ProfileHeader(name:String,bio:String){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(MaterialTheme.colorScheme.surface)
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically){
//        Icon/Avatar
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSurface)
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
            Text(text = name, style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSurface)
            Text(text = bio, style = MaterialTheme.typography.bodyMedium,color = MaterialTheme.colorScheme.onBackground)
        }
    }
}
@Preview(showSystemUi = true,name = "Phone", device = Devices.PIXEL_7)
//@Preview(showSystemUi = true,name = "Tablet", device = Devices.PIXEL_TABLET)
//@Preview(showSystemUi = true,name = "Fold", device = Devices.FOLDABLE)
//@Preview(showSystemUi = true)
@Composable
fun ProfileHeaderPreview(){
    FriendCircleTheme() {
        ProfileHeader(
            name = "Vansh Pratap",
            bio = "21\t:Software Engineer\nLoves Reading & Cooking"
        );
    }
}