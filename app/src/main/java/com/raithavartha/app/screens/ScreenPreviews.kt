package com.raithavartha.app.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.raithavartha.app.ui.theme.RaithaVarthaTheme
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    RaithaVarthaTheme {
        val viewModel = remember { RaithaVarthaViewModel() }
        HomeScreen(viewModel = viewModel, onOpenDetail = {}, onOpenSearch = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    RaithaVarthaTheme {
        val viewModel = remember { RaithaVarthaViewModel() }
        SearchScreen(viewModel = viewModel, onOpenDetail = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExpertScreenPreview() {
    RaithaVarthaTheme {
        AskExpertScreen(viewModel = remember { RaithaVarthaViewModel() })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    RaithaVarthaTheme {
        ProfileScreen(viewModel = remember { RaithaVarthaViewModel() }, onLogout = {})
    }
}
