package dev.donmanuel.recipeappcmp.dbFactory

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import co.touchlab.sqliter.DatabaseConfiguration
import dev.donmanuel.recipeappcmp.RecipeAppCmpAppDb


actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            RecipeAppCmpAppDb.Schema.synchronous(), DB_FILE_NAME,
            onConfiguration = {
                it.copy(
                    extendedConfig = DatabaseConfiguration.Extended(
                        foreignKeyConstraints = true
                    )
                )
            }
        )
    }
}