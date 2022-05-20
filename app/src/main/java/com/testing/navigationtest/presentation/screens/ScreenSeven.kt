package com.testing.navigationtest.presentation.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import com.testing.navigationtest.presentation.navigation.graphs.ScreenThreeNavGraphSecondary
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions


@OptIn(ExperimentalAnimationApi::class)
@ScreenThreeNavGraphSecondary
@Destination(
    style = ScreenTransitions::class,
    route = "screenSeven",
    deepLinks = [
        DeepLink(
            uriPattern = "http://navigationtest.testing.com/screenSeven"
        )
    ]
)
@Composable
fun ScreenSeven(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen Seven", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
    }
}