package dev.donmanuel.recipeappcmp.features.feed.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem
import dev.donmanuel.recipeappcmp.features.common.ui.components.ErrorContent
import dev.donmanuel.recipeappcmp.features.common.ui.components.Loader
import dev.donmanuel.recipeappcmp.features.feed.ui.composables.RecipeCard
import dev.donmanuel.recipeappcmp.features.feed.ui.composables.TopBar
import dev.donmanuel.recipeappcmp.features.feed.ui.composables.TopRecipesList


@Composable
fun FeedScreen(
    navigateToDetail: (Long) -> Unit,
    feedUiState: FeedUiState,
    navigateToSearch: () -> Unit,
) {

    val recipes = feedUiState.recipesList
    Scaffold(
        topBar = {
            TopBar(navigateToSearch)
        }
    ) { innerPadding ->
        when {
            feedUiState.recipesListIsLoading -> {
                Loader()
            }

            feedUiState.recipesListError != null -> {
                ErrorContent()
            }

            recipes != null -> {
                FeedContent(
                    innerPadding = innerPadding,
                    recipes = recipes,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}


@Composable
private fun FeedContent(
    navigateToDetail: (Long) -> Unit,
    innerPadding: PaddingValues,
    recipes: List<RecipeItem>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(
            top = innerPadding.calculateTopPadding()
        )
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            TopRecipesList(
                title = "Top Recommendations",
                recipes = recipes.reversed(),
                navigateToDetail = navigateToDetail
            )
        }

        recipesOfTheWeek(
            title = "Recipes Of the Week", recipes = recipes, navigateToDetail = navigateToDetail
        )

    }
}

private fun LazyGridScope.recipesOfTheWeek(
    navigateToDetail: (Long) -> Unit,
    title: String,
    recipes: List<RecipeItem>
) {

    item(
        span = { GridItemSpan(maxLineSpan) }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
    }

    itemsIndexed(recipes, key = { _, it -> it.id }) { index, recipe ->

        val cardPaddingStart = if (index % 2 == 0) 16.dp else 0.dp
        val cardPaddingEnd = if (index % 2 == 0) 0.dp else 16.dp

        val imageModifier =
            Modifier.fillMaxWidth().height(130.dp).clip(RoundedCornerShape(16.dp))
        RecipeCard(
            recipe,
            modifier = Modifier.padding(start = cardPaddingStart, end = cardPaddingEnd),
            imageModifier = imageModifier.clickable {
                navigateToDetail(recipe.id)
            }
        )
    }
}



