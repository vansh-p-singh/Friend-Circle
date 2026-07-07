package com.altrodav.friendcircle.learning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlignmentBox(){
    Column (
        modifier = Modifier.fillMaxSize().padding(5.dp),
        horizontalAlignment =  Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically)
    ) {
        Text("Text 1");
        Text("Text 2");
        Text("Text 3");
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlignmentBoxPreview(){
    AlignmentBox()
}