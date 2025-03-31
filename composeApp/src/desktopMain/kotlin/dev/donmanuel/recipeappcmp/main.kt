package dev.donmanuel.recipeappcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.donmanuel.recipeappcmp.di.initKoinJvm

val koin = initKoinJvm()

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Recipe App",
    ) {
        App()
    }
}