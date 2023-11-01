package com.dailyvery.imhome.data.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap

class MapRepositoryImpl: MapRepository {

    private var mapboxMap: MapboxMap? = null

    override suspend fun sendMapIntent(mapIntent: MapIntent) {
        when(mapIntent) {
            MapIntent.CenterOnUser -> centerOnUser()
        }
    }

    override fun setMapInstance(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
    }

    private fun centerOnUser() {
        mapboxMap?.locationComponent?.lastKnownLocation?.let { location ->
            val cameraPosition = CameraPosition.Builder().zoom(12.0).target(LatLng(location)).build()
            mapboxMap?.cameraPosition = cameraPosition
        }

    }
}