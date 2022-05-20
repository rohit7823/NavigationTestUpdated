@file:OptIn(ExperimentalMaterialNavigationApi::class)

package com.testing.navigationtest.presentation.screens

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.result.ResultBackNavigator
import com.ramcosta.composedestinations.result.ResultRecipient
import com.testing.navigationtest.presentation.NavGraphs
import com.testing.navigationtest.presentation.destinations.ScreenTwoOneDestination
import com.testing.navigationtest.presentation.destinations.ScreenTwoTwoDestination
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ActivityViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoOneViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoTwoViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoViewModel

@OptIn(ExperimentalMaterialNavigationApi::class)
@ExperimentalAnimationApi
@RootNavGraph
@Destination(
    route = "screenTwo",
    style = ScreenTransitions::class,
    deepLinks = [
        DeepLink(
            uriPattern = "http://navigationtest.testing.com/screenTwo/{id}"
        )
    ]
)
@Composable
fun ScreenTwo(
    activityViewModel: ActivityViewModel,
    viewModel: ScreenTwoViewModel,
    navigator: DestinationsNavigator,
    resultBackNavigator: ResultBackNavigator<String>,
    id: String,
) {
    SideEffect {
        Log.d("EffectScope", "SideEffect")
        viewModel.setNavigator(navigator)
        viewModel.setResultBackNavigator(resultBackNavigator)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen Two Id - $id", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { viewModel.navigateNext() },
        ) { Text(text = "Navigate Further", style = MaterialTheme.typography.titleMedium) }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(modifier = Modifier.fillMaxWidth())
        DestinationsNavHost(navGraph = NavGraphs.screenTwo,
            engine = rememberAnimatedNavHostEngine(),
            dependenciesContainerBuilder = {
                when (destination) {
                    is ScreenTwoOneDestination -> {
                        val parentEntry =
                            remember { navController.getBackStackEntry(NavGraphs.screenTwo.route) }
                        dependency(hiltViewModel<ScreenTwoViewModel>(parentEntry))
                        dependency(hiltViewModel<ScreenTwoOneViewModel>())
                        dependency(destinationsNavigator)
                    }
                    is ScreenTwoTwoDestination -> {
                        dependency(hiltViewModel<ScreenTwoTwoViewModel>())
                    }
                }
            })

        BackHandler(enabled = true) {
            viewModel.sendBackResult()
        }
    }

}