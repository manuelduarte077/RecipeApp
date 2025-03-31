package dev.donmanuel.recipeappcmp.features.search.domain.repositories

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface SearchRecipeRepository {
    suspend fun searchRecipesByText(query: String): Result<List<RecipeItem>>
}