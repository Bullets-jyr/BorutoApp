package kr.co.bullets.borutoapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kr.co.bullets.borutoapp.R
import kr.co.bullets.borutoapp.domain.model.Hero
import kr.co.bullets.borutoapp.ui.theme.DarkGray
import kr.co.bullets.borutoapp.ui.theme.LightGray
import kr.co.bullets.borutoapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import kr.co.bullets.borutoapp.ui.theme.SMALL_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
//    error: LoadState.Error,
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {
//    var message by remember {
//        mutableStateOf(parseErrorMessage(message = error.toString()))
//    }
//    var message by remember {
//        mutableStateOf(parseErrorMessage(error = error))
//    }
    var message by remember {
        mutableStateOf("Find your Favorite Hero!")
    }
//    var icon by remember {
//        mutableStateOf(R.drawable.ic_network_error)
//    }
    var icon by remember {
        mutableStateOf(R.drawable.ic_search_document)
    }

    if (error != null) {
        message = parseErrorMessage(error = error)
        icon = R.drawable.ic_network_error
    }

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Icon(
//            modifier = Modifier
//                .size(NETWORK_ERROR_ICON_HEIGHT)
//                .alpha(alpha = alphaAnim),
//            painter = painterResource(id = icon),
//            contentDescription = stringResource(R.string.network_error_icon),
//            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
//        )
//        Text(
//            modifier = Modifier
//                .padding(top = SMALL_PADDING)
//                .alpha(alpha = alphaAnim),
//            text = message,
//            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Medium,
//            fontSize = MaterialTheme.typography.subtitle1.fontSize
//        )
//    }

    EmptyContent(
        alphaAnim = alphaAnim,
        icon = icon,
        message = message
    )

//    EmptyContent(
//        alphaAnim = alphaAnim,
//        icon = icon,
//        message = message,
//        heroes = heroes,
//        error = error
//    )
}

@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String,
//    error: LoadState.Error? = null,
//    heroes: LazyPagingItems<Hero>? = null
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alpha = alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alpha = alphaAnim),
            text = message,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }

//    var isRefreshing by remember { mutableStateOf(false) }
//
//    SwipeRefresh(
//        swipeEnabled = error != null,
//        state = rememberSwipeRefreshState(isRefreshing),
//        onRefresh = {
//            isRefreshing = true
//            heroes?.refresh()
//            isRefreshing = false
//        }
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Icon(
//                modifier = Modifier
//                    .size(NETWORK_ERROR_ICON_HEIGHT)
//                    .alpha(alpha = alphaAnim),
//                painter = painterResource(id = icon),
//                contentDescription = stringResource(R.string.network_error_icon),
//                tint = if (isSystemInDarkTheme()) LightGray else DarkGray
//            )
//            Text(
//                modifier = Modifier
//                    .padding(top = SMALL_PADDING)
//                    .alpha(alpha = alphaAnim),
//                text = message,
//                color = if (isSystemInDarkTheme()) LightGray else DarkGray,
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.Medium,
//                fontSize = MaterialTheme.typography.subtitle1.fontSize
//            )
//        }
//    }
}

//fun parseErrorMessage(message: String): String {
//    Log.d("parseErrorMessage", "$message")
//    return when {
//        message.contains("SocketTimeoutException") -> {
//            "Server Unavailable."
//        }
//        message.contains("ConnectException") -> {
//            "Internet Unavailable."
//        }
//        else -> {
//            "Unknown Error."
//        }
//    }
//}

fun parseErrorMessage(error: LoadState.Error): String {
    return when (error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable."
        }
        is ConnectException -> {
            "Internet Unavailable."
        }
        else -> {
            "Unknown Error."
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyScreenPreview() {
//    EmptyScreen(error = LoadState.Error(SocketTimeoutException()))
    EmptyContent(
//        alphaAnim = 1f,
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        message = "Internet Unavailable."
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun EmptyScreenDarkPreview() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        message = "Internet Unavailable."
    )
}