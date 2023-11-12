package com.dailyvery.imhome.core.di.module

import com.dailyvery.imhome.data.search.remote.GeoLocationApi
import com.dailyvery.imhome.data.search.repository.MapToolKitSearchRepository
import com.dailyvery.imhome.domain.search.repository.SearchRepository
import com.dailyvery.imhome.domain.search.usecase.SearchLocationImpl
import com.dailyvery.imhome.domain.search.usecase.interfaces.SearchLocation
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val contentType = "application/json".toMediaType()
val json = Json { ignoreUnknownKeys = true }
var searchModule = module {

    single<GeoLocationApi> {
        Retrofit.Builder()
            .baseUrl(GeoLocationApi.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(GeoLocationApi::class.java)
    }

    single<SearchRepository> {
        MapToolKitSearchRepository(get(), androidContext())
    }

    factory<SearchLocation> {
        SearchLocationImpl(get())
    }

}