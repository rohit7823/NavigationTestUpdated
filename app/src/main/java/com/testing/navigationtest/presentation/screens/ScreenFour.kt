package com.testing.navigationtest.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.testing.navigationtest.presentation.navigation.graphs.ScreenThreeNavGraphPrimary
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ScreenFourViewModel

@ScreenThreeNavGraphPrimary(start = true)
@Destination(style = NestedScreenTransitions::class)
@Composable
fun ScreenFour(
    viewModel: ScreenFourViewModel,
    destinationsNavigator: DestinationsNavigator,
) {
    SideEffect {viewModel.setNavigator(destinationsNavigator)}

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Screen Four", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.navigateNext() }) {
            Text(text = "Navigate", style = MaterialTheme.typography.titleMedium)
        }
    }
}