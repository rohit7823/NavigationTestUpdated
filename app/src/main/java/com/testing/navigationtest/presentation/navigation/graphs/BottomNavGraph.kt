package com.testing.navigationtest.presentation.navigation.graphs

import com.ramcosta.composedestinations.annotation.NavGraph

@NavGraph
annotation class BottomNavGraph(
    val start: Boolean = false,
    val route: String = "bottomNav/"
)
