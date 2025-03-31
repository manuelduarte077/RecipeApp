package dev.donmanuel.recipeappcmp.features.common.data.database

import dev.donmanuel.recipeappcmp.RecipeAppCmpAppDb
import dev.donmanuel.recipeappcmp.dbFactory.DatabaseFactory
import devdonmanuelrecipeappcmp.Recipe
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driverFactory: DatabaseFactory
) {

    private var db: RecipeAppCmpAppDb? = null
    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: suspend (RecipeAppCmpAppDb) -> Result) =
        mutex.withLock {
            if (db == null) {
                db = createDb(driverFactory)
            }

            return@withLock block(db!!)
        }

    private suspend fun createDb(driverFactory: DatabaseFactory): RecipeAppCmpAppDb {
        return RecipeAppCmpAppDb(
            driver = driverFactory.createDriver(),
            RecipeAdapter = Recipe.Adapter(
                ingredientsAdapter = listOfStringsAdapter,
                instructionsAdapter = listOfStringsAdapter
            )
        )
    }
}