package com.example.scipnet.homescreen.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scipnet.Routes
import kotlin.text.isDigit

@Composable
fun HomeView(nav: NavController) {
    var link by remember { mutableStateOf("173") }
    Column {
        Surface() {
            Text(
                text = "Hello there!",
                modifier = Modifier.padding(6.dp)
            )
        }

        TextField(
            value = link,
            onValueChange = { newText ->
                link = newText.filter { it.isDigit() }
            },
            label = { Text("What scp you want?") }
        )

        Button(onClick = {
            nav.navigate(Routes.scp + "/$link")
        }) {
            Text("GO!")
        }
    }
}