package dev.donmanuel.recipeappcmp.features.search.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

@Composable
fun SearchRecipeItem(
    item: RecipeItem,
    onRecipeItemClicked: (RecipeItem) -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth().clickable {
            onRecipeItemClicked(item)
        }.padding(16.dp)
    ) {

        AsyncImage(
            model = item.imageUrl,
            onError = {
                println("AsyncImage_onError=${it.result.throwable}")
            },
            modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column {
            Text(
                textAlign = TextAlign.Start,
                text = item.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {

                Row(
                    modifier = Modifier.padding(end = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = item.duration,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                    )
                    Text(
                        text = " ${item.rating}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                }
            }
        }
    }
}