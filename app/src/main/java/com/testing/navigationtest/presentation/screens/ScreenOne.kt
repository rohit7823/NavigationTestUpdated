package com.testing.navigationtest.presentation.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient
import com.testing.navigationtest.presentation.destinations.ScreenTwoDestination
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ActivityViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenOneViewModel

@OptIn(ExperimentalAnimationApi::class)
@RootNavGraph(start = true)
@Destination(style = ScreenTransitions::class)
@Composable
fun ScreenOne(
    activityViewModel: ActivityViewModel,
    screenOneViewModel: ScreenOneViewModel,
    navigator: DestinationsNavigator,
    resultRecipient: ResultRecipient<ScreenTwoDestination, String>,
) {
    SideEffect { screenOneViewModel.setNavigator(navigator) }
    val inform = remember { mutableStateOf("") }

    resultRecipient.onNavResult { result ->
        when (result) {
            is NavResult.Value -> {
                inform.value = result.value
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen One", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { screenOneViewModel.navigateNext() }) {
            Text(text = "Navigate")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { screenOneViewModel.navigateToBottomBar() }) {
            Text(text = "Navigate Bottom Bar")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = inform.value, style = MaterialTheme.typography.titleMedium)
    }
}