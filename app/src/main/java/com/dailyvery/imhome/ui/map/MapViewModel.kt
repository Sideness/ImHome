package com.dailyvery.imhome.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.usecase.interfaces.SendMapIntent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MapViewModel(
    private val sendMapIntent: SendMapIntent,
): ViewModel() {

    fun centerOnUserLocation() {
        viewModelScope.launch {
            sendMapIntent(MapIntent.CenterOnUser)
        }
    }

}