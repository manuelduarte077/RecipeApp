package dev.donmanuel.recipeappcmp.features.app.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import dev.donmanuel.recipeappcmp.features.app.data.AppConstants.IS_LOGGED_IN
import dev.donmanuel.recipeappcmp.features.detail.navigation.navigateToDetail
import dev.donmanuel.recipeappcmp.features.search.navigation.navigateToSearch
import dev.donmanuel.recipeappcmp.features.tabs.navigation.navigateToTabs
import dev.donmanuel.recipeappcmp.preferences.AppPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun rememberAppState(
    navController: NavHostController,
    scope: CoroutineScope = rememberCoroutineScope(),
    appPreferences: AppPreferences
): AppState {

    return remember(navController, scope) {
        AppState(navController, scope, appPreferences)
    }
}


@Stable
class AppState(
    val navController: NavHostController, scope: CoroutineScope, val appPreferences: AppPreferences
) {

    private var _isLoggedIn = MutableStateFlow(appPreferences.getBoolean(IS_LOGGED_IN, false))
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun navigateToTabs() = navController.navigateToTabs()
    fun navigateToDetail(id: Long) = navController.navigateToDetail(id)
    fun navigateToSearch() = navController.navigateToSearch()
    fun navigateBack() = navController.navigateUp()

    fun updateIsLoggedIn(isLoggedIn: Boolean) {
        this._isLoggedIn.value = isLoggedIn
        appPreferences.putBoolean(IS_LOGGED_IN, isLoggedIn)
    }

    fun onLogout() {
        updateIsLoggedIn(false)
    }

}
