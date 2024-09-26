package com.dailyvery.imhome.ui.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.dailyvery.imhome.R
import org.koin.androidx.compose.koinViewModel

/**
 * Maplibre doesn't provide a compose view so we need to encapsulate it in an AndroidView
 */
@Composable
fun Map(
    viewModel: MapViewModel = koinViewModel(),
) {
    val mapView = rememberMapView(viewModel::saveMapInstance, viewModel::centerOnUserLocation)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { mapView },
            modifier = Modifier.fillMaxSize()
        )
        Button(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomEnd),
            onClick = { viewModel.centerOnUserLocation() }
        ) {
            Text(text = stringResource(R.string.map_button_text_center))
        }
    }

}