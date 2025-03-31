package dev.donmanuel.recipeappcmp

import dev.donmanuel.recipeappcmp.dbFactory.DatabaseFactory
import dev.donmanuel.recipeappcmp.di.initKoin
import dev.donmanuel.recipeappcmp.preferences.MultiplatformSettingsFactory
import org.koin.dsl.module

val iosModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinIOS() = initKoin(additionalModules = listOf(iosModules))
