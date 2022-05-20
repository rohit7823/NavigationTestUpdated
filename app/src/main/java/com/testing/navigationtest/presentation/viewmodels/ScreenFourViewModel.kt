package com.testing.navigationtest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.destinations.ScreenFiveDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenFourViewModel @Inject constructor(

): ViewModel() {

    private lateinit var navigator: DestinationsNavigator

    fun setNavigator(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    fun navigateNext() {
        navigator.navigate(ScreenFiveDestination)
    }
}