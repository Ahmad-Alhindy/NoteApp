package com.example.noteapp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NoteScreen(navController: NavController, notes: MutableList<Note>) {
    var title by remember { mutableStateOf("") }
    var content by remember{ mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color(0xFF5FC6EE)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        TextField(
            maxLines = 1,
            value = title,
            onValueChange = {
                if (it.length <= 25) {  // Set the character limit here
                    title = it
                }
            },
            label = { Text("Title") }
        )
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") }
        )

        ElevatedButton(onClick = {
            if (title.isBlank() && content.isBlank()){
                errorMessage = "You have to write something"
            }
            else if (title.length < 5) {
                errorMessage = ("the Title should be bigger than 5")
            }
            else if (content.length < 10) {
                errorMessage = ("the Content should be bigger than 10")
            }
            else if (title.length > 25) {
                errorMessage = ("the Title should be smaller than 25")
            }
            else if (content.length > 500) {
                errorMessage = ("the Content should be smaller than 500")
            }
            else {
                errorMessage = ""
                notes.add(Note(id= notes.size, title = title, content = content))
                navController.popBackStack()
            }
                                 },
            modifier = Modifier.padding(30.dp))
        {
            Text("Add Note" ,
            fontSize = 20.sp ,
            color = Color.Black
        )

        }
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}



