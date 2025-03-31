package dev.donmanuel.recipeappcmp.features.search.data.datasources

import dev.donmanuel.recipeappcmp.features.common.data.database.daos.RecipeDao
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

class SearchRecipeLocalDataSourceImpl(
    private val recipeDao: RecipeDao
) : SearchRecipeLocalDataSource {
    override suspend fun searchRecipesByText(query: String): List<RecipeItem> {
        return recipeDao.searchRecipesByText(query)
    }
}