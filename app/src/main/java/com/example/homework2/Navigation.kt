package com.example.homework2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


// made/copied with the tutorial video
// https://www.youtube.com/watch?v=4gUeyNkGE3g&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=18


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){

        }
    }
}

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

}

@Composable
fun MainScreen(navController: NavController){
    // how it looks. Columns etc
    Button(
        onClick = {
            navController.navigate(Screen.DetailScreen.route)
        }
    ){
        Text (text = "To DetailScreen")
    }
}

@Composable
fun DetailScreen(name: String){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello, $name")
    }
    // example
}
