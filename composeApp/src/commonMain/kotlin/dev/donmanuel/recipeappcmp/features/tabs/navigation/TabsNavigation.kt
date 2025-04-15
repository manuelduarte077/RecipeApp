package dev.donmanuel.recipeappcmp.features.tabs.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.donmanuel.recipeappcmp.features.app.data.Screen
import dev.donmanuel.recipeappcmp.features.tabs.ui.TabsRoute

fun NavController.navigateToTabs(navOptions: NavOptions? = null) {
    navigate(Screen.Tabs.route)
}

fun NavGraphBuilder.tabsNavGraph(
    navigateToDetail: (Long) -> Unit,
    navigateToSearch: () -> Unit,
    tabNavController: NavHostController,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit
) {

    composable(Screen.Tabs.route) {
        TabsRoute(
            tabNavController = tabNavController,
            navigateToDetail = navigateToDetail,
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
            onLogout = onLogout,
            navigateToSearch = navigateToSearch
        )
    }
}