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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raithavartha.app.ui.components.CompactAdvisoryCard
import com.raithavartha.app.ui.components.EmptyStateCard
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Composable
fun SearchScreen(
    viewModel: RaithaVarthaViewModel,
    onOpenDetail: (Int) -> Unit
) {
    val results = viewModel.searchResults()

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
            Text("Search Tips", style = MaterialTheme.typography.headlineMedium, color = androidx.compose.ui.graphics.Color.White)
            Text("ಹುಡುಕಿ", style = MaterialTheme.typography.titleMedium, color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.88f))
        }

        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = viewModel::updateSearch,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            label = { Text("Search crop, disease or farming tip / ಬೆಳೆ ಅಥವಾ ರೋಗ ಹುಡುಕಿ") },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            if (results.isEmpty()) {
                item {
                    EmptyStateCard(
                        title = "No matching tips",
                        subtitle = "Try paddy, leaf spot, irrigation or ರಾಗಿ."
                    )
                }
            } else {
                item {
                    Text(
                        text = "${results.size} results / ಫಲಿತಾಂಶಗಳು",
                        style = MaterialTheme.typography.titleMedium,
                        color = LeafGreen
                    )
                    Spacer(Modifier.height(2.dp))
                }
                items(results) { advisory ->
                    CompactAdvisoryCard(
                        advisory = advisory,
                        isSaved = viewModel.isSaved(advisory.id),
                        onSave = { viewModel.toggleSaved(advisory.id) },
                        onClick = { onOpenDetail(advisory.id) }
                    )
                }
            }
            item { Spacer(Modifier.height(10.dp)) }
        }
    }
}
