package com.example.scipnet

import android.os.Bundle
import android.util.Log
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
import it.skrape.core.htmlDocument
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val extracted = skrape(HttpFetcher) {
            request {
                url = link
            }
            extractIt<PageInfo> { res ->
                htmlDocument{
                    res.title = "#page-title" { findFirst { text } }
                    res.data = "#page-content" { findFirst { text } }
                }
            }
        }



        enableEdgeToEdge()
        setContent {
            SCiPNetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        title = extracted.title,
                        data = extracted.data,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

const val link = "https://scp-wiki.wikidot.com/scp-173"

data class PageInfo(
    var title: String = "",
    var data: String = ""
)

private fun fetch() {
    val extracted = skrape(HttpFetcher) {
        request {
            url = link
        }
        extractIt<PageInfo> { res ->
            htmlDocument{
                res.title = "#page-title" { findFirst { text } }
                res.data = "#page-content" { findFirst { text } }
            }
        }
    }
//    Log.d("SCPTITLE", extracted.title)
//    Log.d("SCPDATA", extracted.data)
}


@Composable
fun Greeting(title: String, data: String, modifier: Modifier = Modifier) {
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

//    LazyColumn {
//        items(scps) {
//            ListItem(it)
//        }
//    }
}

@Composable
fun ListItem(name: String) {
//    Card(
//        modifier = Modifier.fillMaxWidth()
//            .padding(12.dp)
//    ) {
//        Text(
//            text = name,
//            modifier = Modifier.padding(24.dp)
//        )
//    }
}