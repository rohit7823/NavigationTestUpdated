package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.ViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.destinations.BottomBarScreenDestination
import com.testing.navigationtest.presentation.destinations.ScreenTwoDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenOneViewModel @Inject constructor(

) : ViewModel() {
    private var navigator: DestinationsNavigator? = null

    fun setNavigator(destinationsNavigator: DestinationsNavigator) {
        navigator = destinationsNavigator
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun navigateNext() {
        navigator?.navigate(ScreenTwoDestination.route)
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun navigateToBottomBar() {
        navigator?.navigate(BottomBarScreenDestination)
    }

}