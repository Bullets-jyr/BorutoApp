package kr.co.bullets.borutoapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import kr.co.bullets.borutoapp.presentation.screens.details.DetailsScreen
import kr.co.bullets.borutoapp.presentation.screens.home.HomeScreen
import kr.co.bullets.borutoapp.presentation.screens.search.SearchScreen
import kr.co.bullets.borutoapp.presentation.screens.splash.SplashScreen
import kr.co.bullets.borutoapp.presentation.screens.welcome.WelcomeScreen
import kr.co.bullets.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
//        startDestination = Screen.Welcome.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
//            SearchScreen()
            SearchScreen(navController = navController)
        }
    }
}
