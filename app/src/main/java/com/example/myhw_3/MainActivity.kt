package com.example.myhw_3

import androidx.navigation.compose.currentBackStackEntryAsState


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyApp()
        }
    }
}

@Composable
fun RickAndMortyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        NavigationHost(navController = navController, paddingValues = innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Rick and Morty API") }
    )
}

@Composable
fun EpisodeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img_4),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f) // Set height to 50% of the screen height
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(
                text = """
                    "Rick and Morty" is an animated science fiction sitcom created by Justin Roiland and Dan Harmon. 
                    The show follows the interdimensional adventures of Rick Sanchez, a brilliant but eccentric scientist, 
                    and his good-hearted but easily influenced grandson, Morty Smith. The series explores themes of 
                    existentialism, nihilism, and the meaning of life through a mix of dark humor, satire, and clever storytelling.
                """.trimIndent(),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun RickScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img_5),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
        )
        Text(
            text = "Rick Screen Description",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Composable
fun CharacterScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img_6), // Replace with actual image
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f) // Set height to 50% of the screen height
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(
                text = "This is the character screen. Add more details about characters here.",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "characters",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("characters") { CharacterScreen() }
        composable("episodes") { EpisodeScreen() }
        composable("rick") { RickScreen() }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        BottomBarItem("Characters", "characters", R.drawable.img_2),
        BottomBarItem("Episodes", "episodes", R.drawable.img), // Replace with actual image
        BottomBarItem("Rick", "rick", R.drawable.img_1) // Replace with actual image
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = null) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

data class BottomBarItem(val label: String, val route: String, val icon: Int)
