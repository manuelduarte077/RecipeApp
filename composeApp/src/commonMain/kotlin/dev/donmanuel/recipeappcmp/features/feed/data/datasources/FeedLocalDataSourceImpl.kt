package dev.donmanuel.recipeappcmp.features.feed.data.datasources

import dev.donmanuel.recipeappcmp.features.common.data.database.daos.RecipeDao
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

class FeedLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): FeedLocalDataSource {
    override suspend fun getRecipesList(): List<RecipeItem> {
       return recipeDao.getAllRecipes()
    }

    override suspend fun saveRecipesList(recipes: List<RecipeItem>) {
        recipeDao.insertRecipesBulk(recipes)
    }
}