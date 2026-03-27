package com.formation.seriestracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage // Dépendance Coil 3
import com.formation.seriestracker.domain.model.TvShow

@Composable
fun CarteSerie(tvShow: TvShow) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {

            // Miniature chargée avec Coil
            AsyncImage(
                model = tvShow.imageUrl,
                contentDescription = "Miniature de ${tvShow.name}",
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.weight(1f)) {
                // Titre de la série
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // Chaîne de diffusion et pays
                Text(
                    text = "${tvShow.network} - ${tvShow.country}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Badge coloré pour le statut
                val (badgeColor, textColor) = if (tvShow.status.equals("Running", ignoreCase = true)) {
                    Color(0xFF4CAF50) to Color.White // Vert pour Running
                } else {
                    Color.Gray to Color.White // Gris pour Ended
                }

                Box(
                    modifier = Modifier
                        .background(color = badgeColor, shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = tvShow.status,
                        color = textColor,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}