package com.dailyvery.imhome.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.usecase.interfaces.SendMapIntent
import com.dailyvery.imhome.domain.map.usecase.interfaces.SetMapInstance
import com.mapbox.mapboxsdk.maps.MapboxMap
import kotlinx.coroutines.launch

class MapViewModel(
    private val sendMapIntent: SendMapIntent,
    private val setMapInstance: SetMapInstance,
): ViewModel() {

    fun centerOnUserLocation() {
        viewModelScope.launch {
            sendMapIntent(MapIntent.CenterOnUser)
        }
    }

    fun saveMapInstance(mapboxMap: MapboxMap) {
        viewModelScope.launch {
            setMapInstance(mapboxMap)
        }
    }

}