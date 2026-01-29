package com.example.homework2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.homework2.Chat


// made/copied with the tutorial video
// https://www.youtube.com/watch?v=4gUeyNkGE3g&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=18


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController=navController)
        }
        composable (route = Screen.DetailScreen.route + "/{name}",
            arguments= listOf(
            navArgument("Name"){
                type = NavType.StringType
                defaultValue = "kethu"
            }
        )){ entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
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
    Surface() {
        Mainscrn(chats = SampleData.conversationSample)
    }
    Button(
        onClick = {
            navController.navigate(Screen.DetailScreen.route)
        }
    ){}
}

@Composable
fun DetailScreen(name: String?){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello, $name")
    }
    // example
}
