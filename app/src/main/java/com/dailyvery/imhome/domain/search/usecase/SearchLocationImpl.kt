package com.dailyvery.imhome.domain.search.usecase

import com.dailyvery.imhome.domain.search.model.GeoLocation
import com.dailyvery.imhome.domain.search.repository.SearchRepository
import com.dailyvery.imhome.domain.search.usecase.interfaces.SearchLocation

class SearchLocationImpl(
    private val searchRepository: SearchRepository,
): SearchLocation {

    override suspend fun invoke(searchedLocation: String): List<GeoLocation> {
        return searchRepository.searchDestination(searchedLocation)
    }
}