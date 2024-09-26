package com.dailyvery.imhome.domain.map.usecase

import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.dailyvery.imhome.domain.map.usecase.interfaces.SetMapInstance
import com.mapbox.mapboxsdk.maps.MapboxMap

class SetMapInstanceImpl(
    private val mapRepository: MapRepository,
): SetMapInstance {
    override fun invoke(mapboxMap: MapboxMap) {
        mapRepository.setMapInstance(mapboxMap)
    }
}