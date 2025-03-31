package dev.donmanuel.recipeappcmp.di

import dev.donmanuel.recipeappcmp.features.detail.ui.RecipeDetailViewModel
import dev.donmanuel.recipeappcmp.features.favorites.ui.FavoritesScreenViewModel
import dev.donmanuel.recipeappcmp.features.feed.ui.FeedViewModel
import dev.donmanuel.recipeappcmp.features.login.ui.LoginViewModel
import dev.donmanuel.recipeappcmp.features.profile.ui.ProfileViewModel
import dev.donmanuel.recipeappcmp.features.search.ui.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        FeedViewModel(get())
    }

    viewModel {
        RecipeDetailViewModel(get())
    }

    viewModel {
        FavoritesScreenViewModel(get())
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        LoginViewModel()
    }
    viewModel {
        SearchViewModel(get())
    }

}