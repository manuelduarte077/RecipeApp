package dev.donmanuel.recipeappcmp.features.tabs.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.donmanuel.recipeappcmp.features.app.data.Screen
import dev.donmanuel.recipeappcmp.features.favorites.navigation.favoritesNavGraph
import dev.donmanuel.recipeappcmp.features.feed.navigation.feedNavGraph
import dev.donmanuel.recipeappcmp.features.profile.navigation.profileNavGraph
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

val tabItems = listOf(
    Screen.Home,
    Screen.Favorites,
    Screen.Profile,
)

@Composable
fun TabsRoute(
    tabNavController: NavHostController,
    navigateToDetail: (Long) -> Unit,
    navigateToSearch: () -> Unit,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit
) {

    TabsScreen(
        tabNavController = tabNavController,
        navigateToDetail = navigateToDetail,
        isUserLoggedIn = isUserLoggedIn,
        openLoginBottomSheet = openLoginBottomSheet,
        onLogout = onLogout,
        navigateToSearch = navigateToSearch
    )

}

@Composable
fun TabsScreen(
    tabNavController: NavHostController,
    navigateToDetail: (Long) -> Unit,
    navigateToSearch: () -> Unit,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
                val navBackStackEntry by tabNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                tabItems.forEach { topLevelRoute ->
                    val isSelected =
                        currentDestination?.hierarchy?.any { it.route == topLevelRoute.route } == true

                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                        icon = {
                            val icon =
                                if (isSelected) topLevelRoute.selectedIcon else topLevelRoute.unselectedIcon

                            val color =
                                if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onBackground
                            icon?.let {
                                Icon(
                                    tint = color,
                                    modifier = Modifier.size(20.dp),
                                    painter = painterResource(icon),
                                    contentDescription = topLevelRoute.route
                                )
                            }
                        },
                        label = { Text(stringResource(topLevelRoute.resourceId)) },
                        selected = isSelected,
                        onClick = {
                            tabNavController.navigate(topLevelRoute.route) {
                                popUpTo(tabNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }) { innerPadding ->
        NavHost(
            tabNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            feedNavGraph(
                navigateToDetail = navigateToDetail,
                isUserLoggedIn = isUserLoggedIn,
                openLoginBottomSheet = openLoginBottomSheet,
                navigateToSearch = navigateToSearch
            )
            favoritesNavGraph(
                navigateToDetail = navigateToDetail,
                isUserLoggedIn = isUserLoggedIn,
            )
            profileNavGraph(
                isUserLoggedIn = isUserLoggedIn,
                openLoginBottomSheet = openLoginBottomSheet,
                onLogout = onLogout
            )
        }
    }
}