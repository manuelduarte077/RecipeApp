package dev.donmanuel.recipeappcmp.features.favorites.domain

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeRepository {
    suspend fun getAllFavoriteRecipes(): Result<List<RecipeItem>>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}