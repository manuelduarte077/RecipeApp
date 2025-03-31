package dev.donmanuel.recipeappcmp.features.feed.data.datasources

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedRemoteDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
}