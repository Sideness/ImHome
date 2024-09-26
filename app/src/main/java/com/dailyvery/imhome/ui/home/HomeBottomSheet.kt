package com.dailyvery.imhome.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeBottomSheet(
    viewModel: HomeBottomSheetViewModel = koinViewModel()
) {
    val searchText by viewModel.searchedDestination.collectAsState("")

    Column {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                viewModel.updateSearchedDestination(it)
            })
    }

    LaunchedEffect(Unit) {
        viewModel.initInputObserver()
    }
}