package dev.donmanuel.recipeappcmp.di

import dev.donmanuel.recipeappcmp.dbFactory.DatabaseFactory
import dev.donmanuel.recipeappcmp.preferences.MultiplatformSettingsFactory
import org.koin.dsl.module

val jsModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJs() = initKoin(additionalModules = listOf(jsModules))
