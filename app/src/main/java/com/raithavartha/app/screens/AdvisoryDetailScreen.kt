package com.raithavartha.app.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raithavartha.app.model.Advisory
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.ui.theme.SunYellow

@Composable
fun AdvisoryDetailScreen(
    advisory: Advisory?,
    isSaved: Boolean,
    onBack: () -> Unit,
    onSave: () -> Unit
) {
    if (advisory == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Advisory not found")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.height(330.dp)) {
            AsyncImage(
                model = advisory.imageUrl,
                contentDescription = advisory.cropEnglish,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.18f), Color.Black.copy(alpha = 0.68f))
                        )
                    )
            )
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(22.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.White.copy(alpha = 0.16f),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f))
                ) {
                    Text(
                        "${advisory.cropEnglish} | ${advisory.category}",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                    )
                }
                Spacer(Modifier.height(14.dp))
                Text(advisory.titleEnglish, style = MaterialTheme.typography.headlineMedium, color = Color.White)
                Text(advisory.titleKannada, style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = 0.9f))
            }
        }

        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
            DetailCard(title = "Quick Summary / ಸಾರಾಂಶ", accent = LeafGreen) {
                Text(advisory.tipEnglish, style = MaterialTheme.typography.bodyLarge)
                Spacer(Modifier.height(8.dp))
                Text(advisory.tipKannada, style = MaterialTheme.typography.bodyLarge, color = Color(0xFF4F584F))
                Spacer(Modifier.height(18.dp))
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null, tint = LeafGreen)
                    Text("  Listen in Audio / ಆಡಿಯೋದಲ್ಲಿ ಕೇಳಿ", color = LeafGreen, fontWeight = FontWeight.Bold)
                }
            }
            DetailCard(title = "Recommendation Details", accent = SunYellow) {
                DetailRow("Dosage", advisory.dosage)
                DetailRow("Weather", advisory.weather)
                DetailRow("Source", advisory.source)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DetailAction(
                    icon = if (isSaved) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                    label = if (isSaved) "Saved" else "Save",
                    onClick = onSave
                )
                DetailAction(Icons.Filled.Share, "Share", onClick = {})
                DetailAction(Icons.AutoMirrored.Filled.VolumeUp, "Listen", onClick = {})
            }
        }
    }
}

@Composable
private fun DetailCard(
    title: String,
    accent: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .fillMaxHeight()
                    .background(accent)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(22.dp)
            ) {
                Text(title, style = MaterialTheme.typography.titleLarge, color = accent)
                Spacer(Modifier.height(16.dp))
                content()
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(label, modifier = Modifier.weight(0.8f), color = Color(0xFF6B706B), fontWeight = FontWeight.Bold)
        Text(value, modifier = Modifier.weight(1.6f), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun DetailAction(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Icon(icon, contentDescription = label, tint = LeafGreen, modifier = Modifier.size(22.dp))
        Text(" $label", color = LeafGreen, fontWeight = FontWeight.Bold)
    }
}
