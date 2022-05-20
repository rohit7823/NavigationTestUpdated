package com.testing.navigationtest.presentation.viewmodels

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.SomeRepo
import com.testing.navigationtest.presentation.destinations.DirectionDestination
import com.testing.navigationtest.presentation.destinations.ScreenThreeDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ScreenTwoOneViewModel @Inject constructor(
    private val someRepo: SomeRepo,
) : ViewModel() {
    private lateinit var navigator: DestinationsNavigator
    val requestScreenChange = mutableStateOf<DirectionDestination?>(null)

    init {
        viewModelScope.launch {
            Log.d("DI", "${someRepo.getSomeData()}")
        }
    }


    fun setNavigator(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun navigateNext() {
        //navigator.navigate(ScreenTwoTwoDestination)
        requestScreenChange.value = ScreenThreeDestination
    }


}