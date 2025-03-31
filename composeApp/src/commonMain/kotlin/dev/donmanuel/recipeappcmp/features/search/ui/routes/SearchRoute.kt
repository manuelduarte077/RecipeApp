package dev.donmanuel.recipeappcmp.features.search.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import dev.donmanuel.recipeappcmp.features.search.ui.SearchScreen
import dev.donmanuel.recipeappcmp.features.search.ui.SearchViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchRoute(
    navigateToDetail: (Long) -> Unit,
    onBackPress: () -> Unit,
    searchViewModel: SearchViewModel = koinViewModel()
) {
    val screenState = searchViewModel.searchScreenUiState.collectAsState()
    val searchText = searchViewModel.searchText.collectAsState()

    SearchScreen(
        searchText = searchText.value,
        onSearchTextChanged = {
            searchViewModel.onSearchQueryChanged(it)
        },
        searchScreenState = screenState.value,
        onRecipeItemClicked = {
            navigateToDetail(it.id)
        },
        onBackPress = onBackPress
    )
}
