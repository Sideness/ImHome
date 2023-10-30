package com.dailyvery.imhome.domain.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.mapbox.mapboxsdk.maps.MapboxMap
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    suspend fun sendMapIntent(mapIntent: MapIntent)
    fun setMapboxMapInstance(mapboxMap: MapboxMap)
}