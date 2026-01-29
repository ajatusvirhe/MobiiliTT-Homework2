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


// made with the tutorial videos
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

//@Composable
/*fun MainScreen(navController: NavController){
    // how it looks. Columns etc
    Surface() {
        Mainscrn(chats = SampleData.conversationSample, navController)
    }
    Button(
        onClick = {
            navController.navigate(Screen.DetailScreen.route)
        }
    ){}
}*/

//@Composable
/*fun DetailScreen(name: String?){
    Surface{
        var thischat = SampleData.conversationSample.get(0) // the first by default
        for (conv in SampleData.conversationSample){
            if(conv.sender.equals(name)){
                thischat = conv
            }
        }
        Conversation(thischat)
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello, $name")
    }
    // example
}*/
