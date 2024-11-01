package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.theme.NoteAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp1.nav

class Note (
    val id : Int,
    var title : String,
    var content : String,
    val completed : MutableState<Boolean> = mutableStateOf(false)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                val NoteList = remember { mutableStateListOf<Note>() }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = nav.homeScreen, builder = {
                    composable(nav.homeScreen) {
                        HomeScreen(navController = navController)
                    }
                    composable(nav.addNote) {
                        NoteScreen(navController = navController, NoteList)
                    }
                    composable(nav.showMyNotes) {
                        NoteLista(navController = navController, NoteList)
                    }
                    composable("editTodo/{noteid}") { backStackEntry ->
                        val noteid = backStackEntry.arguments?.getString("noteid")?.toIntOrNull()
                        val todoItem = NoteList.find { it.id == noteid }
                        todoItem?.let {
                        EditNoteScreen(navController = navController, it)}
                    }

                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddNote() {
    NoteAppTheme {
        val Note = Note(1, "Hello", "World")
        EditNoteScreen(navController = rememberNavController(), Note)
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview1() {
    NoteAppTheme {
        HomeScreen(navController = rememberNavController())

    }
}