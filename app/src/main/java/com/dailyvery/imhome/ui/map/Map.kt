package com.dailyvery.imhome.ui.map

import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.koin.androidx.compose.koinViewModel

/**
 * Maplibre doesn't provide a compose view so we need to encapsulate it in an AndroidView
 */
@Composable
fun Map(
    viewModel: MapViewModel = koinViewModel()
) {
    val mapView = rememberMapView()

    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize()
    )
    Button(
        modifier = Modifier.wrapContentSize().align(Alignment.),
        onClick = { viewModel.centerOnUserLocation() }
    ) {

    }
}