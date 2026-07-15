package com.altrodav.friendcircle.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.altrodav.friendcircle.screens.ProfileScreen
import com.altrodav.friendcircle.WelcomeScreen
import com.altrodav.friendcircle.screens.Circles
import com.altrodav.friendcircle.screens.Home
import com.altrodav.friendcircle.screens.ScreenMainActivity

object Routes{
    const val HOME = "home";
    const val PROFILE = "profile";
    const val activities = "activities";
    const val circles="circles"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavApp(){
    val navController = rememberNavController();
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Friend Circle")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation Button")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
         bottomBar = {
             AppNavigationBar(navController)
         }
    ){
            innerPadding->
        NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(innerPadding)){
            composable(Routes.HOME) {
                Home()
            }
            composable(Routes.PROFILE) {
                ProfileScreen(navController);
            }
            composable (Routes.activities ){
                ScreenMainActivity(navController)
            }
            composable(Routes.circles){
                Circles(navController);
            }

        }

    }
}


// Navigation Bar
@Composable
fun AppNavigationBar(navController: NavController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(){
        NavigationBarItem(selected = currentRoute == Routes.HOME, onClick = { navController.navigate(Routes.HOME){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        } }, icon = {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        },
            label = {
                Text("Home")
            })
        NavigationBarItem(selected = currentRoute == Routes.PROFILE, onClick = { navController.navigate(Routes.PROFILE){
            launchSingleTop=true
        } }, icon = {
            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
        },
            label = {
                Text("Profile")
            })
        NavigationBarItem(selected = currentRoute == Routes.activities, onClick = { navController.navigate(Routes.activities) {
            launchSingleTop=true
            restoreState=true
        } }, icon = {
            Icon(Icons.Filled.AddCircle, contentDescription = "Activities")
        },
            label = {
                Text("Activities")
            })
        NavigationBarItem(selected = currentRoute == Routes.circles, onClick = { navController.navigate(Routes.circles){
            launchSingleTop=true
        } }, icon = {
            Icon(Icons.Filled.Face, contentDescription = "Profile")
        },
            label = {
                Text("Circles")
            })
    }
}