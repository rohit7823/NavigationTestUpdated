@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)

package com.testing.navigationtest.presentation.bottombarscreens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.utils.contains
import com.testing.navigationtest.presentation.NavGraphs
import com.testing.navigationtest.presentation.destinations.HomeScreenDestination
import com.testing.navigationtest.presentation.destinations.ProfileScreenDestination
import com.testing.navigationtest.presentation.destinations.SettingsScreenDestination
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.BottomBarViewModel
import com.testing.navigationtest.presentation.viewmodels.HomeViewModel
import com.testing.navigationtest.presentation.viewmodels.ProfileViewModel
import com.testing.navigationtest.presentation.viewmodels.SettingsViewModel


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@RootNavGraph
@Destination(style = ScreenTransitions::class)
@Composable
fun BottomBarScreen(
    viewModel: BottomBarViewModel
) {
    Scaffold(
        bottomBar = { BottomMenusContent(viewModel) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            DestinationsNavHost(
                navGraph = NavGraphs.bottom,
                engine = rememberAnimatedNavHostEngine(),
                dependenciesContainerBuilder = {
                    SideEffect { viewModel.setNavigator(destinationsNavigator) }
                    dependency(viewModel)

                    when (destination) {
                        is HomeScreenDestination -> {
                            dependency(hiltViewModel<HomeViewModel>())
                        }
                        is ProfileScreenDestination -> {
                            dependency(hiltViewModel<ProfileViewModel>())
                        }
                        is SettingsScreenDestination -> {
                            dependency(hiltViewModel<SettingsViewModel>())
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun BottomMenusContent(viewModel: BottomBarViewModel) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 5.dp,
    ) {
        repeat(viewModel.bottomMenus.size) {
            NavigationBarItem(
                selected = it == viewModel.selectedIdx.value,
                onClick = { viewModel.onNavigate(viewModel.bottomMenus[it].destination, it) },
                icon = {
                    Icon(
                        imageVector = viewModel.bottomMenus[it].icon,
                        contentDescription = "Menu Icon"
                    )
                },
                label = {
                    Text(
                        text = viewModel.bottomMenus[it].menuName,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            )
        }
    }
}
