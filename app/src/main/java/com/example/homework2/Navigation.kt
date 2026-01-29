package com.example.homework2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


// made with the tutorial videos, structure mostly copied from there
// https://www.youtube.com/watch?v=4gUeyNkGE3g&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=18
//https://www.youtube.com/watch?v=wJKwsI5WUI4

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route, builder = {
        composable(route = Screen.MainScreen.route){
            Mainscrn(SampleData.conversationSample, navController)
        }
        composable (route = Screen.KethuScreen.route){
            ChatScreen(SampleData.conversationSample.get(0), navController)
        }
        composable (route = Screen.NapakettuScreen.route){
            ChatScreen(SampleData.conversationSample.get(1), navController)
        }
    })
}

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object KethuScreen : Screen("kethu_screen")
    object NapakettuScreen : Screen("napakettu_screen")

}