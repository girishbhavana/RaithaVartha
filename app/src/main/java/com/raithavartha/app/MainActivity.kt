package com.raithavartha.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raithavartha.app.navigation.RaithaVarthaNavHost
import com.raithavartha.app.ui.theme.RaithaVarthaTheme
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaithaVarthaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: RaithaVarthaViewModel = viewModel()
                    RaithaVarthaNavHost(viewModel = viewModel)
                }
            }
        }
    }
}
