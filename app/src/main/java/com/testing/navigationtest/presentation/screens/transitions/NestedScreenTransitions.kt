package com.testing.navigationtest.presentation.screens.transitions

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.DestinationStyle
import com.testing.navigationtest.presentation.appDestination
import com.testing.navigationtest.presentation.destinations.*

@OptIn(ExperimentalAnimationApi::class)
object NestedScreenTransitions : DestinationStyle.Animated {

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return when (initialState.appDestination()) {
            ScreenTwoOneDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenTwoTwoDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenFourDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenFiveDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            HomeScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            SettingsScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ProfileScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return when (initialState.appDestination()) {
            ScreenTwoOneDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenTwoTwoDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenFourDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenFiveDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            HomeScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ProfileScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            SettingsScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {
        return when (initialState.appDestination()) {
            ScreenTwoOneDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenTwoTwoDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenFourDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ScreenFiveDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            HomeScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            ProfileScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            SettingsScreenDestination -> {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    tween(700),
                    initialOffset = { it }
                )
            }
            else -> null
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {
        return when (initialState.appDestination()) {
            ScreenTwoOneDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenTwoTwoDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenFourDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ScreenFiveDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            HomeScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ProfileScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            ProfileScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            SettingsScreenDestination -> {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(700),
                    targetOffset = { it }
                )
            }
            else -> null
        }
    }

}