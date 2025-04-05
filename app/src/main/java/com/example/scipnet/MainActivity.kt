package com.example.scipnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scipnet.homescreen.presentation.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = Routes.home, builder = {
                composable ( Routes.home, ) {
                    HomeView(nav)
                }
                composable( Routes.scp+"/{link}",) {
                    val link = it.arguments?.getString("link")
                    PageView(link)
                }
            })
        }
    }
}