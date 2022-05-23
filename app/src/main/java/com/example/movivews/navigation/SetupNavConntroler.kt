package com.example.movivews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movivews.MainViewModel
import com.example.movivews.screen.MainScreen
import com.example.movivews.screen.SplashScreen
import com.example.movivews.utils.Constans

sealed class Screens(val route:String){
    object Splash:Screens(route = Constans.Screens.SPLASH_SCREEN)
    object Main:Screens(route = Constans.Screens.MAIN_SCREEN)
    object Details:Screens(route = Constans.Screens.DETAILS_SCREEN)
}

@Composable

fun setupNavHost(navController: NavHostController,viewModel: MainViewModel){
    NavHost(
        navController = navController,
        // первым экраном у нас будет в startDestination экран Splash
        startDestination = Screens.Splash.route ){
            composable(route = Screens.Splash.route){
                SplashScreen(navController=navController,viewModel= viewModel)
            }
            composable(route = Screens.Main.route){
                MainScreen(navController=navController,viewModel= viewModel)
            }
            composable(route = Screens.Details.route){

            }
    }
}