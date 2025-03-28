package com.example.scipnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.scipnet.ui.theme.SCiPNetTheme
import com.example.scipnet.viewscp.data.PageParser

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extracted = PageParser("https://scp-wiki.wikidot.com/scp-069")

        enableEdgeToEdge()
        setContent {
            SCiPNetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Display(
                        title = extracted.getTitle(),
                        data = extracted.getBody(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Display(title: String, data: String, modifier: Modifier = Modifier) {
    Column {
        Surface(color = Color.Cyan) {
            Text(
                text = "This is $title!",
                modifier = modifier.padding(6.dp)
            )
        }
        Text(
            text = data,
            modifier = modifier.padding(6.dp)
        )
    }
}