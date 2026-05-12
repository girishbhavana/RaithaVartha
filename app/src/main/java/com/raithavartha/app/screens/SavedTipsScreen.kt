package com.raithavartha.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raithavartha.app.ui.components.CompactAdvisoryCard
import com.raithavartha.app.ui.components.EmptyStateCard
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Composable
fun SavedTipsScreen(
    viewModel: RaithaVarthaViewModel,
    onOpenDetail: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(LeafGreen)
                .padding(22.dp)
        ) {
            Text("Saved Tips", style = MaterialTheme.typography.headlineMedium, color = Color.White)
            Text("ಉಳಿಸಿದ ಸಲಹೆಗಳು", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = 0.88f))
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            if (viewModel.savedAdvisories.isEmpty()) {
                item {
                    EmptyStateCard(
                        title = "No saved tips yet",
                        subtitle = "Bookmark useful advisories from Home or Search.\nಇಷ್ಟವಾದ ಸಲಹೆಗಳನ್ನು ಉಳಿಸಿ."
                    )
                }
            } else {
                items(viewModel.savedAdvisories) { advisory ->
                    CompactAdvisoryCard(
                        advisory = advisory,
                        isSaved = true,
                        onSave = { viewModel.toggleSaved(advisory.id) },
                        onClick = { onOpenDetail(advisory.id) }
                    )
                }
            }
            item { Spacer(Modifier.height(10.dp)) }
        }
    }
}
