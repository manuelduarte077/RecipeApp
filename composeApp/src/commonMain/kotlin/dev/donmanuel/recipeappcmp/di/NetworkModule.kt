package dev.donmanuel.recipeappcmp.di

import dev.donmanuel.recipeappcmp.features.common.data.api.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun networkModule() = module {

    single<HttpClient> {
        httpClient
    }
}