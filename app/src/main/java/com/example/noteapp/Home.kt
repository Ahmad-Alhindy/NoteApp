package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp1.nav
import androidx.compose.ui.tooling.preview.Preview as Preview1

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFF5FC6EE))
            /* right , top , left , bottom */
            .padding(0.dp, 50.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .height(40.dp),
            text = "My Header",
            fontSize = 30.sp,       // Larger font for a header
            fontWeight = FontWeight.Medium,  // Bold text
            color = Color.Black,
            textAlign = TextAlign.Center,
        )
        Column(modifier = Modifier.padding(vertical = 300.dp)) {
            ElevatedButton(
                onClick = {
                    navController.navigate(nav.addNote)
                },

            ) {
                Text(
                    text = "Add Note",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                onClick = {
                    navController.navigate(nav.showMyNotes)

                },

            ) {
                Text(
                    text = "Show My Notes",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}


