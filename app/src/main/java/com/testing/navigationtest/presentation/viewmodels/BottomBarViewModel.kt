package com.testing.navigationtest.presentation.viewmodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import com.testing.navigationtest.presentation.destinations.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class BottomMenus(val destination: DirectionDestination, val menuName: String, val icon: ImageVector) {
    HOME(destination = HomeScreenDestination, menuName = "Home", icon = Icons.Default.Home),
    PROFILE(destination = ProfileScreenDestination, menuName = "Profile", icon = Icons.Default.Person),
    SETTINGS(
        destination = SettingsScreenDestination,
        menuName = "Settings",
        icon = Icons.Default.Settings
    )
}


@HiltViewModel
class BottomBarViewModel @Inject constructor(

) : ViewModel() {
    val selectedIdx = mutableStateOf(0)
    private lateinit var navigator: DestinationsNavigator
    val bottomMenus = BottomMenus.values().toList()

    fun setNavigator(destinationsNavigator: DestinationsNavigator) {
        navigator = destinationsNavigator
    }

    fun onNavigate(destination: DirectionDestination, currentIdx: Int) {
        navigator.popBackStack()
        navigator.navigate(destination)
        selectedIdx.value = currentIdx
    }
}