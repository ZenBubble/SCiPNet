package com.example.scipnet

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

@Composable
fun PageView(link: String?) {
    val fullLink = "https://scp-wiki.wikidot.com/scp-$link"
    val extracted = PageParser(fullLink)
    val title = extracted.getTitle()
    val data = extracted.getBody()
    Column {
        Surface(color = Color.Cyan) {
            Text(
                text = "This is $title!",
                modifier = Modifier.padding(6.dp)
            )
        }
        Text(
            text = data,
            modifier = Modifier.padding(6.dp)
        )
    }
}
