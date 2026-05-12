package com.raithavartha.app.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun AskExpertScreen(viewModel: RaithaVarthaViewModel) {
    var submitted by remember { mutableStateOf(false) }

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
                .padding(22.dp)
        ) {
            Text("Expert Ask", style = MaterialTheme.typography.headlineMedium, color = Color.White)
            Text("ತಜ್ಞರನ್ನು ಕೇಳಿ", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = 0.88f))
        }

        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            ExpertIntroCard()
            HowToUseCard()
            UploadCard()
            OutlinedTextField(
                value = viewModel.expertProblem,
                onValueChange = viewModel::updateExpertProblem,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                label = { Text("Describe your crop problem / ಬೆಳೆ ಸಮಸ್ಯೆ ವಿವರಿಸಿ") },
                shape = RoundedCornerShape(16.dp)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = { submitted = true },
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = LeafGreen)
                ) {
                    Text("Submit / ಸಲ್ಲಿಸಿ")
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Clear")
                }
            }
            ExpertResponseCard(visible = submitted)
        }
    }
}

@Composable
private fun ExpertIntroCard() {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MintSurface)
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(shape = CircleShape, color = Color.White, modifier = Modifier.size(78.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(Icons.Filled.CameraAlt, contentDescription = null, tint = LeafGreen, modifier = Modifier.size(42.dp))
                }
            }
            Column(modifier = Modifier.padding(start = 18.dp)) {
                Text("AI-Powered Crop Disease Detection", style = MaterialTheme.typography.titleLarge)
                Text("ಬೆಳೆ ರೋಗ ಪತ್ತೆ ತಂತ್ರಜ್ಞಾನ", style = MaterialTheme.typography.titleMedium, color = LeafGreen)
            }
        }
    }
}

@Composable
private fun HowToUseCard() {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("How to Use / ಹೇಗೆ ಬಳಸುವುದು", style = MaterialTheme.typography.titleLarge, color = LeafGreen)
            listOf(
                "Take a clear photo of the affected leaf or plant.",
                "Choose crop type and add symptoms if needed.",
                "Submit to receive a preliminary treatment suggestion."
            ).forEachIndexed { index, text ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(shape = CircleShape, color = LeafGreen, modifier = Modifier.size(42.dp)) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("${index + 1}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                    Text(text, modifier = Modifier.padding(start = 16.dp), style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@Composable
private fun UploadCard() {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Text("Upload Diseased Leaf / ರೋಗಪೀಡಿತ ಎಲೆ ಅಪ್ಲೋಡ್ ಮಾಡಿ", style = MaterialTheme.typography.titleLarge, color = LeafGreen)
            Spacer(Modifier.height(16.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp),
                shape = RoundedCornerShape(18.dp),
                color = MintSurface.copy(alpha = 0.55f),
                border = BorderStroke(1.dp, LeafGreen)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Filled.CloudUpload, contentDescription = null, tint = Color(0xFF72788A), modifier = Modifier.size(64.dp))
                    Spacer(Modifier.height(10.dp))
                    Text("Tap to upload image", style = MaterialTheme.typography.titleLarge)
                    Text("ಚಿತ್ರ ಅಪ್ಲೋಡ್ ಮಾಡಲು ಟ್ಯಾಪ್ ಮಾಡಿ", style = MaterialTheme.typography.titleMedium, color = Color(0xFF6D746D))
                }
            }
        }
    }
}

@Composable
private fun ExpertResponseCard(visible: Boolean) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = LeafGreen)
                Text(
                    " Expert Response / ತಜ್ಞರ ಉತ್ತರ",
                    style = MaterialTheme.typography.titleLarge,
                    color = LeafGreen
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = if (visible) {
                    "You may be facing leaf spot disease. Remove affected leaves, avoid overhead irrigation and consult the nearby agriculture officer.\n\nಎಲೆ ಚುಕ್ಕೆ ರೋಗ ಇರಬಹುದು. ರೋಗಿತ ಎಲೆಗಳನ್ನು ತೆಗೆದುಹಾಕಿ, ಮೇಲಿನಿಂದ ನೀರು ಹಾಕುವುದನ್ನು ತಪ್ಪಿಸಿ ಮತ್ತು ಸಮೀಪದ ಕೃಷಿ ಅಧಿಕಾರಿಯನ್ನು ಸಂಪರ್ಕಿಸಿ."
                } else {
                    "Submit a crop problem to see a sample advisory response.\n\nಬೆಳೆ ಸಮಸ್ಯೆ ಸಲ್ಲಿಸಿದ ನಂತರ ಸಲಹೆ ಇಲ್ಲಿ ಕಾಣುತ್ತದೆ."
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
