package dev.donmanuel.recipeappcmp.features.feed.data.repositories

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedLocalDataSource
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedRemoteDataSource
import dev.donmanuel.recipeappcmp.features.feed.domain.repositories.FeedRepository

class FeedRepositoryImpl(
    private val feedLocalDataSource: FeedLocalDataSource,
    private val feedRemoteDataSource: FeedRemoteDataSource,
): FeedRepository {

    override suspend fun getRecipesList(): Result<List<RecipeItem>> {
        return try {
            val recipeListCache = feedLocalDataSource.getRecipesList()
            val count = recipeListCache.count()
            return if (count > 0) {
                Result.success(recipeListCache)
            } else {
                val recipeListApiResponse = feedRemoteDataSource.getRecipesList()
                feedLocalDataSource.saveRecipesList(recipeListApiResponse)
                Result.success(recipeListApiResponse)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}