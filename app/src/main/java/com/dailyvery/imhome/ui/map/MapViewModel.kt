package com.dailyvery.imhome.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.usecase.interfaces.GetMapIntents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MapViewModel(
    private val getMapIntents: GetMapIntents,
): ViewModel() {

    private val _mapActions = MutableStateFlow<MapActions?>(null)

    init {
        observeMapIntents()
    }

    private fun observeMapIntents() {
        viewModelScope.launch {
            getMapIntents().collect {
                when(it) {
                    MapIntent.Idle -> { /** Nothing for now **/ }
                    MapIntent.CenterOnUser -> {  }
                }
            }
        }
    }

}

sealed class MapActions {
    object CenterOnUser: MapActions()
}