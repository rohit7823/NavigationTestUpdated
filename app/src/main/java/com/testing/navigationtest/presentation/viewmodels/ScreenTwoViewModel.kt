package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.ViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.ResultBackNavigator
import com.testing.navigationtest.presentation.destinations.DirectionDestination
import com.testing.navigationtest.presentation.destinations.ScreenThreeDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenTwoViewModel @Inject constructor(

) : ViewModel() {
    private var navigator: DestinationsNavigator? = null
    private lateinit var resultBackNavigator: ResultBackNavigator<String>

    fun setNavigator(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun navigateNext() {
        navigator?.navigate(ScreenThreeDestination)
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun changeDestination(destination: DirectionDestination) {
        when (destination) {
            ScreenThreeDestination -> {
                navigator?.navigate(destination)
            }
        }
    }

    fun setResultBackNavigator(resultBackNavigator: ResultBackNavigator<String>) {
        this.resultBackNavigator = resultBackNavigator
    }

    fun sendBackResult() {
        resultBackNavigator.navigateBack("A value is returned from Screen Two")
        navigator?.navigateUp()
    }

}