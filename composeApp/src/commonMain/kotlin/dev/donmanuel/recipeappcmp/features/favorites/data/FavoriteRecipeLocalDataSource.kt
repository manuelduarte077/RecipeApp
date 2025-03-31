package dev.donmanuel.recipeappcmp.features.favorites.data

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeLocalDataSource {
    suspend fun getAllFavoriteRecipes(): List<RecipeItem>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}