package com.dailyvery.imhome.domain.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.mapbox.mapboxsdk.maps.MapboxMap

interface MapRepository {
    suspend fun sendMapIntent(mapIntent: MapIntent)
    fun setMapInstance(mapboxMap: MapboxMap)
}