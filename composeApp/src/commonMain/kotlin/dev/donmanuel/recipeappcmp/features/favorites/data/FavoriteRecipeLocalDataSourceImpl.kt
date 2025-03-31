package dev.donmanuel.recipeappcmp.features.favorites.data

import dev.donmanuel.recipeappcmp.features.common.data.database.daos.FavoriteRecipeDao
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

class FavoriteRecipeLocalDataSourceImpl(
    private val favoriteRecipeDao: FavoriteRecipeDao
): FavoriteRecipeLocalDataSource {
    override suspend fun getAllFavoriteRecipes(): List<RecipeItem> {
        return favoriteRecipeDao.getAllFavoriteRecipes()
    }
    override suspend fun addFavorite(recipeId: Long) {
        favoriteRecipeDao.addFavorite(recipeId)
    }
    override suspend fun removeFavorite(recipeId: Long) {
        favoriteRecipeDao.removeFavorite(recipeId)
    }
}