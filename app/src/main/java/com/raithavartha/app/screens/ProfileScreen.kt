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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.ui.theme.MintSurface
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Composable
fun ProfileScreen(
    viewModel: RaithaVarthaViewModel,
    onLogout: () -> Unit
) {
    val profile = viewModel.profile

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(LeafGreen)
                .padding(top = 28.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Surface(shape = CircleShape, color = MintSurface, modifier = Modifier.size(118.dp)) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Filled.Person, contentDescription = null, tint = LeafGreen, modifier = Modifier.size(76.dp))
                    }
                }
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier
                        .size(44.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Filled.CameraAlt, contentDescription = null, tint = LeafGreen)
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(profile.name, color = Color.White, style = MaterialTheme.typography.headlineMedium)
            Text("+91 ${profile.mobile} verified", color = Color.White.copy(alpha = 0.88f), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(10.dp))
            Surface(shape = RoundedCornerShape(12.dp), color = Color.White.copy(alpha = 0.12f)) {
                Text(
                    "${profile.district}, ${profile.taluk}",
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
                )
            }
        }

        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
            StatsCard(saved = viewModel.savedAdvisories.size, crops = viewModel.filters.size - 1, queries = 3)
            InfoCard(
                rows = listOf(
                    "Farmer Name / ರೈತರ ಹೆಸರು" to profile.name,
                    "Mobile Number / ಮೊಬೈಲ್" to "+91 ${profile.mobile}",
                    "District / ಜಿಲ್ಲೆ" to profile.district,
                    "Taluk / ತಾಲ್ಲೂಕು" to profile.taluk,
                    "Preferred Language / ಭಾಷೆ" to profile.language
                )
            )
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(modifier = Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text("Preferences / ಆದ್ಯತೆಗಳು", style = MaterialTheme.typography.titleLarge, color = LeafGreen)
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LeafGreen)
                    ) {
                        Icon(Icons.Filled.Edit, contentDescription = null)
                        Text("  Edit Profile / ಪ್ರೊಫೈಲ್ ಬದಲಿಸಿ")
                    }
                    OutlinedButton(
                        onClick = onLogout,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Icon(Icons.Filled.Logout, contentDescription = null)
                        Text("  Logout / ನಿರ್ಗಮಿಸಿ")
                    }
                }
            }
        }
    }
}

@Composable
private fun StatsCard(saved: Int, crops: Int, queries: Int) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("$saved", "Tips Saved")
            StatItem("$crops", "Crops")
            StatItem("$queries", "Queries")
        }
    }
}

@Composable
private fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.headlineMedium, color = LeafGreen)
        Text(label, style = MaterialTheme.typography.bodyLarge, color = Color(0xFF6B706B))
    }
}

@Composable
private fun InfoCard(rows: List<Pair<String, String>>) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Text("My Information / ನನ್ನ ಮಾಹಿತಿ", style = MaterialTheme.typography.titleLarge, color = LeafGreen)
            Spacer(Modifier.height(16.dp))
            rows.forEach { (label, value) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(label, color = Color(0xFF737873), modifier = Modifier.weight(1f))
                    Text(value, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), color = Color(0xFF222522))
                }
            }
        }
    }
}
