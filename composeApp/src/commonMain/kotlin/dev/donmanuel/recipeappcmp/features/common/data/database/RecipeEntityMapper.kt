package dev.donmanuel.recipeappcmp.features.common.data.database

import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem

fun recipeEntityMapper(recipe: devdonmanuelrecipeappcmp.Recipe) = RecipeItem(
    recipe.id,
    recipe.title,
    recipe.description,
    recipe.category,
    recipe.area,
    recipe.imageUrl,
    recipe.youtubeLink,
    recipe.ingredients,
    recipe.instructions,
    recipe.isFavorite == 1L,
    recipe.rating,
    recipe.duration ?: "20 Mins",
    recipe.difficulty ?: "Easy"
)