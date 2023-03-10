package com.example.mytestapp.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mytestapp.phoneauth.presentation.PhoneAuthUI
import com.example.mytestapp.startup.presentation.SplashScreen
import com.example.mytestapp.userinfo.presentation.UserInfoUI
import com.example.mytestapp.viewpager.presentation.OnBoardingScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class,
    ExperimentalPagerApi::class
)
@Composable
fun ScreenNavigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(
            route = Screen.SplashScreen.route
        ){
            SplashScreen(navController)
        }
        composable(route = Screen.ViewPagerScreen.route){
            OnBoardingScreen(navController)
        }
        composable(route = Screen.PhoneAuthScreen.route){
            PhoneAuthUI(context, navController)
        }
        composable(route = Screen.UserInfoScreen.route) {
            UserInfoUI()
        }
    }
}