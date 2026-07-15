package com.altrodav.friendcircle.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.altrodav.friendcircle.ui.theme.FriendCircleTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainActivity(navController: NavController){

    var name by remember {
        mutableStateOf("")
    }
    var time by remember {
        mutableStateOf("")
    }
    var location by remember {
        mutableStateOf("")
    }
    var showForm by remember {
        mutableStateOf(false)
    }

    var activitiesList = remember {  mutableStateListOf<EventActivity>(
        EventActivity("Open Cooking","12:00PM","Sector 17, Chandigarh")
    )}
        Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.padding(5.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            items(activitiesList){
                item->ActivityCard(item.name,item.time,item.location)
            }
            if(showForm) {
                item{NewActivityForm(
                    name,
                    time,
                    location,
                    { name = it },
                    { time = it },
                    { location = it },
                    { showForm = false },
                    activitiesList)
                }
            }
        }
            FloatingActionButton(onClick = { showForm = !showForm }, modifier = Modifier.align(Alignment.BottomEnd)) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    }


@Preview(showSystemUi = true)
@Composable
fun PreviewScreen(){
    FriendCircleTheme {
        ScreenMainActivity(navController = NavController(Activity()))
    }
}
@Composable
fun ActivityCard(name:String,time:String,location:String){
    ElevatedCard(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
        Row(modifier = Modifier.padding(10.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(name, style = MaterialTheme.typography.titleMedium)
            Column {
                Text(time,style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(1.dp))
                Text(location,style = MaterialTheme.typography.bodyMedium)
                }
            FilledTonalButton(
                onClick = {}
            ) {
                Text("Join")
            }
            }
        }
    }

@Composable
fun NewActivityForm(name:String, time:String, location:String, nameChange:(String)->Unit, timeChange:(String)->Unit, locationChange:(String)->Unit, closeForm:()->Unit, activitiesList: MutableList<EventActivity>){
    Column(
        modifier = Modifier.padding(10.dp).fillMaxWidth().background(MaterialTheme.colorScheme.surface), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                nameChange(it);
            },
            label ={
                Text("Name")
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = location,
            onValueChange = {
                locationChange(it);
            },
            label ={
                Text("Location")
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = time,
            onValueChange = {
                timeChange(it);
            },
            label ={
                Text("Time")
            }
        )
        Button(onClick = {
            activitiesList.add(EventActivity(name,time,location));
            nameChange("");
            timeChange("");
            locationChange("");
            closeForm();
        },modifier = Modifier.fillMaxWidth()) {
            Text("Create")
        }
    }
}

data class EventActivity(val name:String,val time:String,val location:String);
