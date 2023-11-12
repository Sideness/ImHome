package com.dailyvery.imhome.domain.search.repository

import com.dailyvery.imhome.domain.search.model.GeoLocation


interface SearchRepository {
    suspend fun searchDestination(searchedLocation: String): List<GeoLocation>
}