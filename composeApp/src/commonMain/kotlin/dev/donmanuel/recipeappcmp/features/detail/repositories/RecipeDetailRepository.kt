package dev.donmanuel.recipeappcmp.features.detail.repositories

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface RecipeDetailRepository {

    suspend fun getRecipesDetail(id: Long): Result<RecipeItem>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)

}