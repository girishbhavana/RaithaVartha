package com.raithavartha.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.raithavartha.app.ui.components.AdvisoryFlashCard
import com.raithavartha.app.ui.components.CompactAdvisoryCard
import com.raithavartha.app.ui.components.FilterChipsRow
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.FieldGreen
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.ui.theme.SkyBlue
import com.raithavartha.app.ui.theme.SunYellow
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Composable
fun HomeScreen(
    viewModel: RaithaVarthaViewModel,
    onOpenDetail: (Int) -> Unit,
    onOpenSearch: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            HomeHeader(
                farmerName = viewModel.farmerName.ifBlank { "Farmer" },
                onOpenSearch = onOpenSearch
            )
        }
        item {
            WeatherCard(modifier = Modifier.padding(horizontal = 18.dp))
        }
        item {
            FilterChipsRow(
                filters = viewModel.filters,
                selectedFilter = viewModel.selectedFilter,
                onFilterSelected = viewModel::selectFilter,
                modifier = Modifier.padding(horizontal = 18.dp)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Today's Tip", style = MaterialTheme.typography.headlineMedium)
                Text("ಇಂದು ರೈತ ಸಲಹೆಗಳು", color = LeafGreen, style = MaterialTheme.typography.titleMedium)
            }
        }
        item {
            LazyRow(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(viewModel.filteredAdvisories) { advisory ->
                    AdvisoryFlashCard(
                        advisory = advisory,
                        isSaved = viewModel.isSaved(advisory.id),
                        onSave = { viewModel.toggleSaved(advisory.id) },
                        onClick = { onOpenDetail(advisory.id) }
                    )
                }
            }
        }
        item {
            Text(
                text = "All Tips / ಎಲ್ಲಾ ಸಲಹೆಗಳು",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = 18.dp)
            )
        }
        items(viewModel.filteredAdvisories) { advisory ->
            CompactAdvisoryCard(
                advisory = advisory,
                isSaved = viewModel.isSaved(advisory.id),
                onSave = { viewModel.toggleSaved(advisory.id) },
                onClick = { onOpenDetail(advisory.id) },
                modifier = Modifier.padding(horizontal = 18.dp)
            )
        }
        item { Spacer(Modifier.height(10.dp)) }
    }
}

@Composable
private fun HomeHeader(
    farmerName: String,
    onOpenSearch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(Brush.horizontalGradient(listOf(FieldGreen, LeafGreen)))
            .padding(horizontal = 22.dp, vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(shape = CircleShape, color = Color.White.copy(alpha = 0.92f), modifier = Modifier.size(58.dp)) {
            Box(contentAlignment = Alignment.Center) {
                Icon(Icons.Filled.Person, contentDescription = null, tint = LeafGreen, modifier = Modifier.size(36.dp))
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = "Welcome $farmerName",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "ಇಂದು ಸಲಹೆ ನೋಡಿ",
                color = Color.White.copy(alpha = 0.88f),
                style = MaterialTheme.typography.titleMedium
            )
        }
        IconButton(onClick = onOpenSearch) {
            Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Notifications, contentDescription = "Notifications", tint = Color.White)
        }
    }
}

@Composable
private fun WeatherCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = SkyBlue),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Brush.horizontalGradient(listOf(SkyBlue, Color(0xFF14B8A6), LeafGreen)))
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.WbSunny,
                contentDescription = null,
                tint = SunYellow,
                modifier = Modifier.size(52.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 18.dp)
            ) {
                Text("Mysuru, Karnataka", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(4.dp))
                Text(
                    "28°C | Humid 65% | Rain likely in evening",
                    color = Color.White.copy(alpha = 0.92f),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text("Advisory", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
