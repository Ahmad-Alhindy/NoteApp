package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun NoteLista(navController: NavController, notes: MutableList<Note>) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
                containerColor = Color(0xFF5FC6EE)
    ) {padding ->
        LazyColumn(modifier = Modifier.padding(padding), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(notes) { note ->
                ListItem(
                    leadingContent = { Checkbox(
                        checked = note.completed.value,
                        onCheckedChange = { note.completed.value = !note.completed.value }
                    ) },
                    headlineContent = { Text(note.title) },
                    supportingContent = { Text(note.content) },
                    trailingContent = {
                        Row {
                            IconButton(
                                onClick = { navController.navigate("editTodo/${note.id}") }
                            ) {
                                Icon(Icons.Filled.Edit, contentDescription = "Edit Todo")
                            }
                            IconButton(
                                onClick = { notes.remove(note) }
                            ) {
                                Icon(Icons.Filled.Delete, contentDescription = "Delete Todo")
                            }
                        }
                    }
                )
                HorizontalDivider()
            }
        }
    }
}



