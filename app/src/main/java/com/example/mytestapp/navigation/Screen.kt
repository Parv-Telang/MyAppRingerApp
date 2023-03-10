package com.example.mytestapp.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object ViewPagerScreen : Screen("view_pager_screen")
    object PhoneAuthScreen : Screen("phone_auth_screen")
    object UserInfoScreen : Screen("user_info_screen")
}