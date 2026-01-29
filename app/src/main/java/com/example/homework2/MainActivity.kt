package com.example.homework2

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.homework2.ui.theme.Homework2Theme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
import android.content.res.Configuration

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// some of the code is copied from my homework1
// https://developer.android.com/jetpack/compose/tutorial (homework1)
//some is copied from tutorials (listed in Navigaton.kt)
// https://developer.android.com/guide/navigation#kts
//https://developer.android.com/guide/navigation/navcontroller

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework2Theme {
                Surface {
                    Navigation()
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
data class Chat(val sender: String, val body: List<Message>){
    fun getChats(sender: String):List<Message> {
        return this.body
    }
}

@Composable
fun Conversation(messagelist: Chat){//List<Message>) {
    LazyColumn {
        items(messagelist.body) { message ->
            MessageCard(message)
        }
    }
}

@Composable
fun Mainscrn(chats : List<Chat>, navController: NavController){
    LazyColumn {
        items(chats) { chat ->
            ChatCard(chat.body.last(), navController) // latest message sent in this chat
        }
    }
}
@Composable
fun ChatScreen(chat: Chat, navController: NavController){
    Column() {
        Button(onClick = {navController.navigate(Screen.MainScreen.route){
            popUpTo(Screen.MainScreen.route){inclusive=true}
        } },
            modifier = Modifier.offset(10.dp)) {
            Text(
                "Back"
            )
        }
        Conversation(chat)
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Homework2Theme {
        Conversation(SampleData.conversationSample.get(1))
    }
}

/*@Preview
@Composable
fun PreviewMainscreen(){
    Homework2Theme {
        //Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier = Modifier.offset(0.dp,15.dp)) {
            items(SampleData.conversationSample) { chat ->
                ChatCard(chat.body.last()) // latest message sent in this chat
            }
        }
    }
}*/

@Composable
fun MessageCard(msg:Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = if(msg.author == "Kethu") painterResource(R.drawable.kethucrop)
            else painterResource(R.drawable.napakettu_crop),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) // Set image size to 40 dp
                .clip(CircleShape) // Clip image to be shaped as a circle
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        Column( Modifier.clickable { isExpanded = !isExpanded }) {
            Text( // author
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            //message body
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)) {
                Text(text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun ChatCard(msg: Message, navController : NavController) {
    val surfaceColor by animateColorAsState(
        MaterialTheme.colorScheme.surface,
    )
    Surface(color = surfaceColor) {
        Row(
            modifier = Modifier.fillMaxSize().padding(all=4.dp),
        ){
            Image(
                painter = if (msg.author == "Kethu") painterResource(R.drawable.kethucrop)
                else painterResource(R.drawable.napakettu_crop),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp) // Set image size to 40 dp
                    .clip(CircleShape) // Clip image to be shaped as a circle
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick ={
                if (msg.author == "Kethu") navController.navigate(Screen.KethuScreen.route)
                else (navController.navigate(Screen.NapakettuScreen.route))
            }) {
                Column(modifier = Modifier.fillMaxSize()){
                    Text( // author
                        text = msg.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 1.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    Homework2Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard (
                msg = Message("Kethu", "Aasi svengaa")
            )
        }
    }
}