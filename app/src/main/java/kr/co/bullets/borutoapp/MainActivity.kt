package kr.co.bullets.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import kr.co.bullets.borutoapp.navigation.SetupNavGraph
import kr.co.bullets.borutoapp.ui.theme.BorutoAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // https://developer.android.com/jetpack/compose/navigation?hl=ko
    // NavController는 Navigation 구성요소의 중심 API로, 스테이트풀(Stateful)이며 앱의 화면과 각 화면 상태를 구성하는 컴포저블의 백 스택을 추적합니다.
    private lateinit var navController: NavHostController

    @ExperimentalMaterialApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                // 컴포저블에서 rememberNavController() 메서드를 사용하여 NavController를 만들 수 있습니다.
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}