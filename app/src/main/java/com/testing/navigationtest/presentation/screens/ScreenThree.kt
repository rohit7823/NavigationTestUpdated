package com.testing.navigationtest.presentation.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.dependency
import com.testing.navigationtest.presentation.NavGraphs
import com.testing.navigationtest.presentation.destinations.ScreenFourDestination
import com.testing.navigationtest.presentation.destinations.ScreenSixDestination
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ScreenFourViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenSixViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenThreeViewModel

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@RootNavGraph
@Destination(style = ScreenTransitions::class)
@Composable
fun ScreenThree(
    viewModel: ScreenThreeViewModel,
    destinationNavigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DestinationsNavHost(
            navGraph = NavGraphs.screenThreePrimary,
            engine = rememberAnimatedNavHostEngine(),
            dependenciesContainerBuilder = {
                when(destination) {
                    is ScreenFourDestination -> {
                        dependency(hiltViewModel<ScreenFourViewModel>())
                        dependency(destinationsNavigator)
                    }
                }
            },
            modifier = Modifier.weight(1f)
        )
        Divider(modifier = Modifier.fillMaxWidth())
        DestinationsNavHost(navGraph = NavGraphs.screenThreeSecondary,
            engine = rememberAnimatedNavHostEngine(),
            dependenciesContainerBuilder = {
                when(destination) {
                    is ScreenSixDestination -> {
                        dependency(hiltViewModel<ScreenSixViewModel>())
                        dependency(destinationsNavigator)
                    }
                }
            },
            modifier = Modifier.weight(1f)
        )
    }
}