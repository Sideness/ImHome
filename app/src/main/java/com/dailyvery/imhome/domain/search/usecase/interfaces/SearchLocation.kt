package com.dailyvery.imhome.domain.search.usecase.interfaces

import com.dailyvery.imhome.domain.search.model.GeoLocation

interface SearchLocation {
    suspend operator fun invoke(searchedLocation: String): List<GeoLocation>
}