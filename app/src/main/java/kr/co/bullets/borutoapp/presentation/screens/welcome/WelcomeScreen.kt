package kr.co.bullets.borutoapp.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kr.co.bullets.borutoapp.domain.model.OnBoardingPage
import kr.co.bullets.borutoapp.ui.theme.welcomeScreenBackgroundColor
import kr.co.bullets.borutoapp.util.Constants.ON_BOARDING_PAGE_COUNT

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navController: NavHostController) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            state = pagerState,
            count = ON_BOARDING_PAGE_COUNT,
            verticalAlignment = Alignment.Top
        ) { page ->
            PagerScreen(onBoardingPage = pages[page])
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {

}