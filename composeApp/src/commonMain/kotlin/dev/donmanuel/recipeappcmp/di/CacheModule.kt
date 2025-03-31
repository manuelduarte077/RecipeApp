package dev.donmanuel.recipeappcmp.di

import dev.donmanuel.recipeappcmp.features.common.data.database.DbHelper
import dev.donmanuel.recipeappcmp.features.common.data.database.daos.FavoriteRecipeDao
import dev.donmanuel.recipeappcmp.features.common.data.database.daos.RecipeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun cacheModule() = module {

    single<CoroutineContext> { Dispatchers.Default }
    single { CoroutineScope(get()) }

    single { DbHelper(get()) }
    single { RecipeDao(get()) }
    single { FavoriteRecipeDao(get()) }
}