package com.dailyvery.imhome.data.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.mapbox.mapboxsdk.maps.MapboxMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MapRepositoryImpl: MapRepository {

    private var mapboxMap: MapboxMap? = null

    override suspend fun sendMapIntent(mapIntent: MapIntent) {
        when(mapIntent) {
            MapIntent.CenterOnUser -> centerOnUser()
        }
    }

    override fun setMapboxMapInstance(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
    }

    private fun centerOnUser() {
        mapboxMap?.locationComponent?.zoomWhileTracking(10.0, 1000)
    }
}