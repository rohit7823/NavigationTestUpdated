package com.testing.navigationtest.presentation.bottombarscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.testing.navigationtest.presentation.navigation.graphs.BottomNavGraph
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.BottomBarViewModel
import com.testing.navigationtest.presentation.viewmodels.ProfileViewModel


@BottomNavGraph
@Destination(style = NestedScreenTransitions::class)
@Composable
fun ProfileScreen(
    parentViewModel: BottomBarViewModel,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen", style = MaterialTheme.typography.headlineMedium)
    }
}