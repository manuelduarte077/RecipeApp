package dev.donmanuel.recipeappcmp.di

import dev.donmanuel.recipeappcmp.features.detail.data.datasources.RecipeDetailLocalDataSource
import dev.donmanuel.recipeappcmp.features.detail.data.datasources.RecipeDetailLocalDataSourceImpl
import dev.donmanuel.recipeappcmp.features.detail.data.datasources.RecipeDetailRemoteDataSource
import dev.donmanuel.recipeappcmp.features.detail.data.datasources.RecipeDetailRemoteDataSourceImpl
import dev.donmanuel.recipeappcmp.features.detail.data.repositories.RecipeDetailRepositoryImpl
import dev.donmanuel.recipeappcmp.features.detail.repositories.RecipeDetailRepository
import dev.donmanuel.recipeappcmp.features.favorites.data.FavoriteRecipeLocalDataSource
import dev.donmanuel.recipeappcmp.features.favorites.data.FavoriteRecipeLocalDataSourceImpl
import dev.donmanuel.recipeappcmp.features.favorites.data.FavoriteRecipeRepositoryImpl
import dev.donmanuel.recipeappcmp.features.favorites.domain.FavoriteRecipeRepository
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedLocalDataSource
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedLocalDataSourceImpl
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedRemoteDataSource
import dev.donmanuel.recipeappcmp.features.feed.data.datasources.FeedRemoteDataSourceImpl
import dev.donmanuel.recipeappcmp.features.feed.data.repositories.FeedRepositoryImpl
import dev.donmanuel.recipeappcmp.features.feed.domain.repositories.FeedRepository
import dev.donmanuel.recipeappcmp.features.search.data.datasources.SearchRecipeLocalDataSource
import dev.donmanuel.recipeappcmp.features.search.data.datasources.SearchRecipeLocalDataSourceImpl
import dev.donmanuel.recipeappcmp.features.search.data.repositories.SearchRecipeRepositoryImpl
import dev.donmanuel.recipeappcmp.features.search.domain.repositories.SearchRecipeRepository
import dev.donmanuel.recipeappcmp.preferences.AppPreferences
import dev.donmanuel.recipeappcmp.preferences.AppPreferencesImpl
import org.koin.dsl.module

fun dataModule() = module {

    single<AppPreferences> { AppPreferencesImpl(get()) }

    single<FeedLocalDataSource> { FeedLocalDataSourceImpl(get()) }
    single<FeedRemoteDataSource> { FeedRemoteDataSourceImpl(get()) }

    single<RecipeDetailLocalDataSource> { RecipeDetailLocalDataSourceImpl(get(), get()) }
    single<RecipeDetailRemoteDataSource> { RecipeDetailRemoteDataSourceImpl(get()) }

    single<FavoriteRecipeLocalDataSource> { FavoriteRecipeLocalDataSourceImpl(get()) }

    single<FeedRepository> { FeedRepositoryImpl(get(), get()) }
    single<RecipeDetailRepository> { RecipeDetailRepositoryImpl(get(), get()) }
    single<FavoriteRecipeRepository> { FavoriteRecipeRepositoryImpl(get()) }

    single<SearchRecipeLocalDataSource> { SearchRecipeLocalDataSourceImpl(get()) }
    single<SearchRecipeRepository> { SearchRecipeRepositoryImpl(get()) }
}