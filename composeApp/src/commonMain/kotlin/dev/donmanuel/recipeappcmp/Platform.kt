package dev.donmanuel.recipeappcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform