package dev.donmanuel.recipeappcmp.features.feed.data.datasources

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedLocalDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
    suspend fun saveRecipesList(recipes: List<RecipeItem>)
}