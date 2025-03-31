package dev.donmanuel.recipeappcmp.features.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem
import dev.donmanuel.recipeappcmp.features.search.ui.composables.SearchScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    searchScreenState: SearchScreenState,
    onRecipeItemClicked: (RecipeItem) -> Unit,
    onBackPress: () -> Unit
) {

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
            title = {
                Text(
                    text = "Search Recipes"
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = onBackPress
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            }
        )
    }) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SearchScreenContent(
                searchText, onSearchTextChanged, searchScreenState, onRecipeItemClicked
            )
        }
    }
}

