package com.dailyvery.imhome.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyvery.imhome.domain.search.usecase.interfaces.SearchLocation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class HomeBottomSheetViewModel(
    private val searchLocation: SearchLocation,
): ViewModel() {

    private val _searchedDestination = MutableStateFlow("")
    val searchedDestination: Flow<String> = _searchedDestination

    fun updateSearchedDestination(value: String) {
        viewModelScope.launch {
            _searchedDestination.emit(value)
        }
    }

    fun initInputObserver() {
        viewModelScope.launch {
            searchedDestination
                .debounce(500)
                .distinctUntilChanged()
                .collect {
                    doSearch(it)
                }
        }
    }

    private fun doSearch(input: String) {
        viewModelScope.launch {
            val result = searchLocation(input)
            Log.d("SEARCHED", result.toString())
        }
    }

}