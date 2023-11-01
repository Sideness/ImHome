package com.dailyvery.imhome.domain.map.usecase.interfaces

import com.mapbox.mapboxsdk.maps.MapboxMap

interface SetMapInstance {
    operator fun invoke(mapboxMap: MapboxMap)
}