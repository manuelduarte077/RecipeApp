package dev.donmanuel.recipeappcmp.features.favorites.ui

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

data class FavoritesScreenUiState(
    val itemsList: List<RecipeItem>? = null,
    val itemsListIsLoading: Boolean = true,
    val itemsListError: String? = null,
)