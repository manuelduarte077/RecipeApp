package dev.donmanuel.recipeappcmp.features.detail.data.datasources

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

interface RecipeDetailRemoteDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?

}