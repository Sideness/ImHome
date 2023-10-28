package com.dailyvery.imhome.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.usecase.interfaces.SendMapIntent
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val sendMapIntent: SendMapIntent,
): ViewModel() {

    fun centerLocationOnUser() {
        viewModelScope.launch {
            sendMapIntent(MapIntent.CenterOnUser)
        }
    }

}