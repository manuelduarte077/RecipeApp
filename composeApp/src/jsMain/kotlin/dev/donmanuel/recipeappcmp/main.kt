package dev.donmanuel.recipeappcmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.donmanuel.recipeappcmp.di.initKoinJs
import kotlinx.browser.document

val koin = initKoinJs()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App()
    }
}