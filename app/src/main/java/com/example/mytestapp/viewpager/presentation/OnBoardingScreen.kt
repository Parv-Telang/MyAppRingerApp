package com.example.mytestapp.viewpager.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytestapp.R
import com.example.mytestapp.navigation.Screen
import com.example.mytestapp.viewpager.data.PagerItem
import com.example.mytestapp.viewpager.data.dataList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(navController: NavController) {

    val pageState = com.google.accompanist.pager.rememberPagerState()

    Column {

        com.google.accompanist.pager.HorizontalPager(
            count  = dataList.size,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            PageUi(pager = dataList[page])
        }
        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            activeColor = colorResource(id = R.color.purple_500)
        )
        AnimatedVisibility(visible = pageState.currentPage == 2) {
            Button(onClick = {navController.navigate(Screen.PhoneAuthScreen.route)}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
            }
        }
    }
}

@Composable
fun PageUi(pager: PagerItem) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = pager.image),
            contentDescription = pager.description,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pager.description)
    }

}