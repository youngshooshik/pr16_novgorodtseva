package com.example.pr16_novgorodtseva

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val currentRoute = CurrentRoute(navController)
    Scaffold(
        topBar = {
            if(!(currentRoute == "splash" || currentRoute == "onboarding" || currentRoute == "login"))
                TopBar(navController)
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Navigation(navController)
            }
        },
        bottomBar = {
            if(!(currentRoute == "splash" || currentRoute == "onboarding" || currentRoute == "login"))
                BottomNavigationBar(navController = navController)
        },
        containerColor = Color(0xff253334)
    )

    LaunchedEffect(Unit) {
        navController.navigate("splash")
    }

}

@SuppressLint("ComposableNaming")
@Composable
fun CurrentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview
@Composable
fun PreviewMainScreen(){
    MainScreen()
}

@Composable
fun TopBar(navController: NavController) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xff253334),
            titleContentColor = Color.Transparent,
        ),
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(horizontal = 20.dp),
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.hamburger),
                    contentDescription = "hamburger",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("profile")}) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "profile image",
                    modifier = Modifier.size(36.dp)
                )
            }
        },
    )
}

@Composable
fun BottomNavigationBar(navController: NavController){
    BottomAppBar(
        containerColor = Color(0xff253334),
        actions = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { navController.navigate("home") {
                    popUpTo("home")
                } }, modifier = Modifier.size(150.dp)) {
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
                }
                IconButton(onClick = {/* navController.navigate("listen") TODO*/}, modifier = Modifier.size(50.dp)) {
                    Image(painter = painterResource(id = R.drawable.sound), contentDescription = "sound", Modifier.size(36.dp))
                }
                IconButton(onClick = { navController.navigate("profile")}, modifier = Modifier.size(150.dp)) {
                    Image(painter = painterResource(id = R.drawable.profile_icon), contentDescription = "profile", Modifier.size(36.dp))
                }
            }
        }
    )
}