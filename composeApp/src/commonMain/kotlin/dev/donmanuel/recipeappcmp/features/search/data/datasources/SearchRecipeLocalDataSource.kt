package dev.donmanuel.recipeappcmp.features.search.data.datasources

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface SearchRecipeLocalDataSource {
    suspend fun searchRecipesByText(query: String): List<RecipeItem>
}