package dev.donmanuel.recipeappcmp.features.feed.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

@Composable
fun TopRecipesList(
    navigateToDetail: (Long) -> Unit, title: String, recipes: List<RecipeItem>
) {
    Column {
        Text(
            text = title, style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp
            ), modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recipes, key = { it.id }) { recipe ->
                val imageModifier =
                    Modifier.width(120.dp).height(140.dp).clip(RoundedCornerShape(16.dp))

                RecipeCard(
                    recipe,
                    modifier = Modifier.width(110.dp),
                    imageModifier = imageModifier.clickable {
                        navigateToDetail(recipe.id)
                    })
            }
        }
    }
}
