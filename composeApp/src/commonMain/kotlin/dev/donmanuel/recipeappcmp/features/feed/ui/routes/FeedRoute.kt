package dev.donmanuel.recipeappcmp.features.feed.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import dev.donmanuel.recipeappcmp.features.feed.ui.FeedScreen
import dev.donmanuel.recipeappcmp.features.feed.ui.FeedViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FeedRoute(
    navigateToDetail: (Long) -> Unit,
    navigateToSearch: () -> Unit,
    feedViewModel: FeedViewModel = koinViewModel()
) {

    val feedUiState = feedViewModel.feedUiState.collectAsState()

    FeedScreen(
        navigateToDetail = navigateToDetail,
        feedUiState = feedUiState.value,
        navigateToSearch = navigateToSearch
    )
}