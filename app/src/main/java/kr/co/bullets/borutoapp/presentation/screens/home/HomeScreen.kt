package kr.co.bullets.borutoapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import kr.co.bullets.borutoapp.navigation.Screen
import kr.co.bullets.borutoapp.presentation.common.ListContent
import kr.co.bullets.borutoapp.presentation.components.RatingWidget
import kr.co.bullets.borutoapp.ui.theme.LARGE_PADDING

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

//    Scaffold(
//        topBar = {
//            HomeTopBar(onSearchClicked = {})
//        },
//
//    ) {
//        RatingWidget(
//            modifier = Modifier.padding(all = LARGE_PADDING),
//            rating = 5.0
//        )
//    }
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navController.navigate(Screen.Search.route)
            })
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}