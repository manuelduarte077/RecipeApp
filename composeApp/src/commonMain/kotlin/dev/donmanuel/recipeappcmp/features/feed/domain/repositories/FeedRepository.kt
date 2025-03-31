package dev.donmanuel.recipeappcmp.features.feed.domain.repositories

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedRepository {

    suspend fun getRecipesList(): Result<List<RecipeItem>>
}