package com.testing.navigationtest.presentation.bottombarscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.navigation.graphs.BottomNavGraph
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.BottomBarViewModel
import com.testing.navigationtest.presentation.viewmodels.HomeViewModel

@BottomNavGraph(start = true)
@Destination(style = NestedScreenTransitions::class)
@Composable
fun HomeScreen(
    parentViewModel: BottomBarViewModel,
    viewModel: HomeViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home Screen", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.informParent() }) {
            Text(text = "Navigate to Settings")
        }
    }


    LaunchedEffect(key1 = viewModel.desiredDestination.value) {
        viewModel.desiredDestination.value?.let {
            parentViewModel.onNavigate(it, 2)
            viewModel.desiredDestination.value = null
        }
    }
}