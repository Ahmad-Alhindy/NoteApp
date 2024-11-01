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
fun EditNoteScreen(navController: NavController, note: Note) {
    var title by remember { mutableStateOf(note.title) }
    var content by remember{ mutableStateOf(note.content) }

    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color(0xFF5FC6EE)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") }
        )
        ElevatedButton(onClick = { if (title.isNotBlank() && content.isNotBlank()){
            note.title = title
            note.content = content
            navController.popBackStack()
        }
        },
            modifier = Modifier.padding(30.dp))
        {
            Text("Save" ,
                fontSize = 20.sp ,
                color = Color.Black
            )
        }
    }
}
