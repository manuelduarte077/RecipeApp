package dev.donmanuel.recipeappcmp.preferences

import com.russhwolf.settings.Settings

expect class MultiplatformSettingsFactory {
    fun getSettings():  Settings
}