package com.testing.navigationtest.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.NavHostEngine
import com.testing.navigationtest.presentation.activity.MainActivity
import com.testing.navigationtest.presentation.destinations.BottomBarScreenDestination
import com.testing.navigationtest.presentation.destinations.ScreenOneDestination
import com.testing.navigationtest.presentation.destinations.ScreenThreeDestination
import com.testing.navigationtest.presentation.destinations.ScreenTwoDestination
import com.testing.navigationtest.presentation.viewmodels.*


@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@Composable
fun DefaultNavigation(
    defaultNavGraph: NavGraphSpec,
    defaultEngine: NavHostEngine = rememberAnimatedNavHostEngine(),
) {
    DestinationsNavHost(
        navGraph = defaultNavGraph,
        engine = defaultEngine,
        dependenciesContainerBuilder = {
            when (destination) {
                is ScreenOneDestination -> {
                    dependency(hiltViewModel<ScreenOneViewModel>())
                    dependency(destinationsNavigator)
                }
                is ScreenTwoDestination -> {
                    dependency(hiltViewModel<ScreenTwoViewModel>())
                    dependency(destinationsNavigator)
                }
                is ScreenThreeDestination -> {
                    dependency(hiltViewModel<ScreenThreeViewModel>())
                    dependency(destinationsNavigator)
                }
                is BottomBarScreenDestination -> {
                    dependency(hiltViewModel<BottomBarViewModel>())
                }
            }

            dependency(hiltViewModel<ActivityViewModel>(LocalContext.current as MainActivity))
        }
    )
}