package dev.donmanuel.recipeappcmp

import android.app.Application
import dev.donmanuel.recipeappcmp.dbFactory.DatabaseFactory
import dev.donmanuel.recipeappcmp.di.initKoin
import dev.donmanuel.recipeappcmp.preferences.MultiplatformSettingsFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MainApplication : Application() {

    private val androidModules = module {
        single { DatabaseFactory(applicationContext) }
        single { MultiplatformSettingsFactory(applicationContext) }
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(additionalModules = listOf(androidModules)) {
            androidContext(applicationContext)
        }
    }
}