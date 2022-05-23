package com.example.movivews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.movivews.navigation.setupNavHost
import com.example.movivews.ui.theme.MoviVewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviVewsTheme {
                //добавляем навкантролер
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                setupNavHost(navController = navController,viewModel = viewModel)
            }
        }
    }
}

