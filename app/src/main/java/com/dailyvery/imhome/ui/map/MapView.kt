package com.dailyvery.imhome.ui.map

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.maps.MapView

@SuppressLint("MissingPermission")
@Composable
fun rememberMapView(): MapView {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val map = remember {
        Mapbox.getInstance(context)
        MapView(context).apply {
            getMapAsync { mapboxMap ->
                mapboxMap.apply {
                    setStyle("https://demotiles.maplibre.org/style.json") {
                        val locationComponentOptions =
                            LocationComponentOptions
                                .builder(context)
                                .pulseEnabled(true)
                                .build()
                        val locationComponentActivationOptions =
                            LocationComponentActivationOptions.builder(context, it)
                                .locationComponentOptions(locationComponentOptions)
                                .build()
                        mapboxMap.locationComponent.apply {
                            activateLocationComponent(locationComponentActivationOptions)
                            isLocationComponentEnabled = true
                            cameraMode = CameraMode.TRACKING
                            forceLocationUpdate(lastKnownLocation)
                        }

                    }
                }
            }
        }
    }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> map.onStart()
                Lifecycle.Event.ON_RESUME -> map.onResume()
                Lifecycle.Event.ON_PAUSE -> map.onPause()
                Lifecycle.Event.ON_STOP -> map.onStop()
                Lifecycle.Event.ON_DESTROY -> map.onDestroy()
                else -> {
                    /** Throw error? **/
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    return map
}