package dev.donmanuel.recipeappcmp.features.search.ui

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

data class SearchScreenState(
    val idle: Boolean = true,
    val success: Boolean = false,
    val error: String? = null,
    val results: List<RecipeItem> = emptyList()
)