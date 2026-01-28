import com.example.homework2.Message
import com.example.homework2.Chat

/**
 * SampleData for Jetpack Compose Tutorial 
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Chat(
            "Kethu",
            listOf(
                Message(
                    "Kethu",
                    "Mäy...Mäy...Mäy..."
                ),
                Message(
                    "Kethu",
                    """We are both in the same boat ... and it's called Titanic.""".trim()
                ),
                Message(
                    "Kethu",
                    "Aasi svengaa :)"
                ),
                Message(
                    "Kethu",
                    "I didn't know you can now run the emulator directly from Android Studio"
                ),
                Message(
                    "Kethu",
                    "Mäy mäy mäy"
                )
            )
        ),
        Chat(
            "Napakettu",
            listOf(
                Message(
                    "Napakettu",
                    """List of Android versions:
                    |Android KitKat (API 19)
                    |Android Lollipop (API 21)
                    |Android Marshmallow (API 23)
                    |Android Nougat (API 24)
                    |Android Oreo (API 26)
                    |Android Pie (API 28)
                    |Android 10 (API 29)
                    |Android 11 (API 30)
                    |Android 12 (API 31)""".trim()
                ),
                Message(
                    "Napakettu",
                    "Searching for alternatives to XML layouts..."
                ),
                Message(
                    "Napakettu",
                    """Hey, take a look at Jetpack Compose, it's great!
                    |It's the Android's modern toolkit for building native UI.
                    |It simplifies and accelerates UI development on Android.
                    |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
                ),
                Message(
                    "Napakettu",
                    "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
                ),
                Message(
                    "Napakettu",
                    "Android Studio next version's name is Arctic Fox"
                ),
                Message(
                    "Napakettu",
                    "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
                ),
                Message(
                    "Napakettu",
                    "Compose Previews are great to check quickly how a composable layout looks like"
                ),
                Message(
                    "Napakettu",
                    "Previews are also interactive after enabling the experimental setting"
                ),
                Message(
                    "Napakettu",
                    "Have you tried writing build.gradle with KTS?"
                )
            )
        )
    )
}
