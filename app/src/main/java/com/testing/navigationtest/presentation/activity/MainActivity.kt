@file:OptIn(ExperimentalAnimationApi::class)

package com.testing.navigationtest.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.testing.navigationtest.presentation.NavGraphs
import com.testing.navigationtest.presentation.navigation.DefaultNavigation
import com.testing.navigationtest.presentation.viewmodels.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterialNavigationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val activityVM by viewModels<ActivityViewModel>()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DefaultNavigation(defaultNavGraph = NavGraphs.root)
            }
        }
    }
}
