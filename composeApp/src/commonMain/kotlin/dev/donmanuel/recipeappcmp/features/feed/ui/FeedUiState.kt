package dev.donmanuel.recipeappcmp.features.feed.ui

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

data class FeedUiState(
    val recipesList: List<RecipeItem>? = null,
    val recipesListIsLoading: Boolean = true,
    val recipesListError: String? = null,
)