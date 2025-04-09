package com.example.scipnet

import android.util.Log
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
import kotlinx.coroutines.runBlocking

@Composable
fun PageView(link: String?) {
    val fullLink = "https://scp-wiki.wikidot.com/scp-$link"
    var title = ""
    var data = ""
    try {
        val extracted = PageParser(fullLink)
        title = extracted.getTitle()
        data = extracted.getBody()
    } catch (err: Exception) {
        Log.d("SCP_VIEW_ERROR", err.toString())
        Surface(color = Color.Red) {
            Text(
                text = "ERROR!:" + err.toString(),
            )
        }
    }
    DisplaySCP(title, data)
}

@Composable
fun DisplaySCP(title:String, data:String) {
    Column {
        Surface() {
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
