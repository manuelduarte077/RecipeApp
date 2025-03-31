package dev.donmanuel.recipeappcmp.features.detail.ui

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

data class RecipeDetailUiState(
    val recipesDetail: RecipeItem? = null,
    val recipesDetailIsLoading: Boolean = true,
    val recipesDetailError: String? = null,
)
