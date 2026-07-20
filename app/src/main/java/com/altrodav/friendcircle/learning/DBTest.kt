package com.altrodav.friendcircle.learning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.altrodav.friendcircle.PrimaryButton
import com.altrodav.friendcircle.db.ProfileDatabase
import com.altrodav.friendcircle.db.ProfileEntity
import kotlinx.coroutines.launch

@Composable
fun DBTest() {
    var name by remember {
        mutableStateOf("")

    }
    var bio by remember {
        mutableStateOf("")

    }
    var img by remember {
        mutableStateOf("")

    }
    val context = LocalContext.current
    val database = remember {
        ProfileDatabase.getDatabase(context)
    }
    val dao = remember {
        database.profileDao()
    }

    var savedProfile by remember {
        mutableStateOf<ProfileEntity?>(null)
    }
    var scope=rememberCoroutineScope()
    LaunchedEffect(Unit) {
        savedProfile = dao.getProfileById(1)

        // Populate the text fields with the saved data
        savedProfile?.let {
            name = it.name
            bio = it.bio
            img = it.img ?: ""
        }
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        OutlinedTextField(value = name, onValueChange = {
            name = it
        }, label = {
            Text("Name")
        }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = bio, onValueChange = {
            bio = it
        }, label = {
            Text("Bio")
        }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = img, onValueChange = {
            img = it
        }, label = {
            Text("Image")
        }, modifier = Modifier.fillMaxWidth())

//        Save Button
        PrimaryButton("Save", onClick = {
            scope.launch {

                val profile = ProfileEntity(
                    id = 1,
                    name = name,
                    bio = bio,
                    img = img
                )

                dao.insertProfile(profile)

                savedProfile = dao.getProfileById(1)
            }
        }, modifier = Modifier.fillMaxWidth())
        savedProfile?.let {

            Text("Saved Profile")

            Text("Name: ${it.name}")

            Text("Bio: ${it.bio}")

            Text("Image: ${it.img}")

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDbTest(){
    DBTest()
}