package com.dailyvery.imhome.ui.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.dailyvery.imhome.R
import com.dailyvery.imhome.core.utils.Colors
import com.dailyvery.imhome.ui.home.HomeBottomSheet
import org.koin.androidx.compose.koinViewModel

/**
 * Maplibre doesn't provide a compose view so we need to encapsulate it in an AndroidView
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapHome(
    viewModel: MapViewModel = koinViewModel()
) {
    val mapView = rememberMapView()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BottomSheetScaffold(
            sheetContent = { HomeBottomSheet() },
        ) {
            AndroidView(
                factory = { mapView },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}