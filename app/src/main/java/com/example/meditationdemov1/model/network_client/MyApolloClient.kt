package com.example.meditationdemov1.model.network_client

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

object MyApolloClient {

    const val BASE_URL = "https://rickandmortyapi.com/graphql/"

    private val okHttpClient = OkHttpClient.Builder().build()
    val apolloClient = ApolloClient.builder()
        .serverUrl(BASE_URL)
        .okHttpClient(okHttpClient)
        .build()

}