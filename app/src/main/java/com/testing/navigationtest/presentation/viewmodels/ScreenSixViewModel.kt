package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.ViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.destinations.ScreenSevenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenSixViewModel @Inject constructor(

): ViewModel() {

    private lateinit var navigator:DestinationsNavigator

    fun setNavigator(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun navigateNext() {
        navigator.navigate(ScreenSevenDestination)
    }

}