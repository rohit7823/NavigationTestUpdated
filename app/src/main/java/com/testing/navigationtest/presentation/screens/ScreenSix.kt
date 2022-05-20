package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.navigation.graphs.ScreenThreeNavGraphSecondary
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions

@OptIn(ExperimentalAnimationApi::class)
@ScreenThreeNavGraphSecondary(start = true)
@Destination(style = ScreenTransitions::class)
@Composable
fun ScreenSix(
    viewModel: ScreenSixViewModel,
    destinationsNavigator: DestinationsNavigator
) {
    SideEffect { viewModel.setNavigator(destinationsNavigator) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen Six", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.navigateNext() }) {
            Text(text = "Navigate", style = MaterialTheme.typography.titleMedium)
        }
    }
}