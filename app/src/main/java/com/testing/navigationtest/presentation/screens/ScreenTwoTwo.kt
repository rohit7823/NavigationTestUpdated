package com.testing.navigationtest.presentation.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.testing.navigationtest.presentation.navigation.graphs.ScreenTwoNavGraph
import com.testing.navigationtest.presentation.screens.transitions.NestedScreenTransitions
import com.testing.navigationtest.presentation.screens.transitions.ScreenTransitions
import com.testing.navigationtest.presentation.viewmodels.ScreenTwoTwoViewModel


@ExperimentalAnimationApi
@ScreenTwoNavGraph
@Destination(style = NestedScreenTransitions::class)
@Composable
fun ScreenTwoTwo(
    viewModel: ScreenTwoTwoViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2.2", style = MaterialTheme.typography.headlineMedium)
    }
}