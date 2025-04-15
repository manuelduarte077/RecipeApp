package dev.donmanuel.recipeappcmp.features.search.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.donmanuel.recipeappcmp.features.common.domain.entities.RecipeItem
import dev.donmanuel.recipeappcmp.features.search.ui.SearchScreenState

@Composable
fun SearchScreenContent(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    searchScreenState: SearchScreenState,
    onRecipeItemClicked: (RecipeItem) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).padding(bottom = 16.dp)
    ) {

        OutlinedTextField(
            shape = MaterialTheme.shapes.medium, value = searchText, onValueChange = {
                onSearchTextChanged(it)
            }, placeholder = {
                Text(
                    text = "Search Recipe Items...",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                    )
                )
            }, modifier = Modifier.background(
                MaterialTheme.colorScheme.onPrimary
            ).fillMaxWidth(), singleLine = true, leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }, colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                focusedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                cursorColor = MaterialTheme.colorScheme.primaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {
            searchScreenState.error != null -> {
                Text(
                    text = "No Recipe Items found",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            searchScreenState.success && searchScreenState.results.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(searchScreenState.results, key = {
                        it.id
                    }) { item ->
                        SearchRecipeItem(item = item, onRecipeItemClicked = onRecipeItemClicked)
                    }
                }
            }
        }
    }
}

