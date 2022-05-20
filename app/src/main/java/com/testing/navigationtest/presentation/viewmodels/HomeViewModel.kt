package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.testing.navigationtest.presentation.destinations.DirectionDestination
import com.testing.navigationtest.presentation.destinations.SettingsScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {
    val desiredDestination = mutableStateOf<DirectionDestination?>(null)

    fun informParent() {
        desiredDestination.value = SettingsScreenDestination
    }


}