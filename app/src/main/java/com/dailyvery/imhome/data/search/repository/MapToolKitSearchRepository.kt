package com.dailyvery.imhome.data.search.repository

import android.content.Context
import com.dailyvery.imhome.data.search.mapper.toGeoLocation
import com.dailyvery.imhome.data.search.remote.GeoLocationApi
import com.dailyvery.imhome.domain.search.model.GeoLocation
import com.dailyvery.imhome.domain.search.repository.SearchRepository

class MapToolKitSearchRepository(
    private val geoLocationApi: GeoLocationApi,
    private val context: Context,
) : SearchRepository {

    override suspend fun searchDestination(searchedLocation: String): List<GeoLocation> {
        return geoLocationApi.searchLocation(
            searchedLocation,
            context.resources.configuration.locales.get(0).isO3Language
        ).map { it.toGeoLocation() }
    }

}