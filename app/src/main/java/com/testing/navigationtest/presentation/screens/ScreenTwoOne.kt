package com.testing.navigationtest.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.navigation.graphs.ScreenTwoNavGraph
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoOneViewModel
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoViewModel

@ScreenTwoNavGraph(start = true)
@Destination(style = NestedScreenTransitions::class)
@Composable
fun ScreenTwoOne(
    sharedViewModel: ScreenTwoViewModel,
    viewModel: ScreenTwoOneViewModel,
    navigator: DestinationsNavigator
) {
    SideEffect { viewModel.setNavigator(navigator) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2.1", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.navigateNext() }) {
            Text(text = "Navigate")
        }
    }

    LaunchedEffect(key1 = viewModel.requestScreenChange.value) {
        viewModel.requestScreenChange.value?.let {
            sharedViewModel.changeDestination(it)
            viewModel.requestScreenChange.value = null
        }
    }
}