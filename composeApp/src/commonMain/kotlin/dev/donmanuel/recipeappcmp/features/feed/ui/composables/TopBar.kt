package dev.donmanuel.recipeappcmp.features.feed.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(navigateToSearch: () -> Unit) {
    Column(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars) //we need to consume status bars padding here, as we are not doing it on the NavHost becoz from there it will apply to all tab screen
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Text(
            text = "Manuel Duarte",
            color = MaterialTheme.colorScheme.primaryContainer,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Got a tasty dish in mind?",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )

        RecipeSearchBar(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp).height(45.dp)
                .background(MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
                )
                .padding(horizontal = 16.dp)
                .clickable {
                    navigateToSearch()
                },
        )

    }

}