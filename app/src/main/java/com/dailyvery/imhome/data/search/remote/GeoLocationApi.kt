package com.dailyvery.imhome.data.search.remote

import com.dailyvery.imhome.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface GeoLocationApi {

    @GET("geocode/search")
    suspend fun searchLocation(
        @Query("q") searchedLocation: String,
        @Query("language") language: String,
        @Query("limit") limit: Int = 10,
        @Header("X-RapidAPI-Key") key: String = BuildConfig.RAPID_API_KEY,
    ): List<GeoLocationDto>

    companion object {
        const val BASE_URL = "https://maptoolkit.p.rapidapi.com/"
    }
}