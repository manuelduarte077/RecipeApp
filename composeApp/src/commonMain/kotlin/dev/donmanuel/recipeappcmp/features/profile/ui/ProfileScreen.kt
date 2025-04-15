package dev.donmanuel.recipeappcmp.features.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.donmanuel.recipeappcmp.features.common.ui.components.ErrorContent
import dev.donmanuel.recipeappcmp.features.common.ui.components.Loader
import dev.donmanuel.recipeappcmp.features.profile.ui.composables.NotLoggedInProfileScreen
import dev.donmanuel.recipeappcmp.features.profile.ui.composables.ProfileContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileRoute(
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit,
    profileViewModel: ProfileViewModel = koinViewModel()
) {

    val profileScreenUiState = profileViewModel.profileUiState.collectAsState()

    ProfileScreen(
        isUserLoggedIn = isUserLoggedIn,
        profileScreenUiState = profileScreenUiState.value,
        onEditProfile = {},
        onLogout = {
            onLogout()
        },
        onLogin = {
            openLoginBottomSheet {
                profileViewModel.refresh()
            }
        })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    isUserLoggedIn: () -> Boolean,
    profileScreenUiState: ProfileScreenUiState,
    onEditProfile: () -> Unit,
    onLogin: () -> Unit,
    onLogout: () -> Unit
) {
    println("isUserLoggedIn=${isUserLoggedIn.invoke()}")
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.background
                ), title = {
                    Text("Profile")
                })
        }) { innerPadding ->
        Column(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
        ) {
            HorizontalDivider(
                thickness = 0.3.dp, color = MaterialTheme.colorScheme.outline.copy(
                    alpha = 0.5f
                )
            )

            when {

                !isUserLoggedIn() -> {
                    NotLoggedInProfileScreen(
                        onLogin = onLogin, onSignUp = {})
                }

                profileScreenUiState.isLoading -> {
                    Loader()
                }

                profileScreenUiState.error != null -> {
                    ErrorContent()
                }

                profileScreenUiState.userInfo != null && isUserLoggedIn() -> {
                    ProfileContent(
                        userInfo = profileScreenUiState.userInfo,
                        onEditProfile = onEditProfile,
                        onLogout = onLogout
                    )
                }
            }
        }
    }
}


