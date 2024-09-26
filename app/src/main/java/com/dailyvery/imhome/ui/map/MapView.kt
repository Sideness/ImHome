package com.dailyvery.imhome.ui.map

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.dailyvery.imhome.BuildConfig
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap

@SuppressLint("MissingPermission")
@Composable
fun rememberMapView(
    setMapInstance: (MapboxMap) -> Unit,
    centerOnUser: () -> Unit,
): MapView {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val map = remember {
        Mapbox.getInstance(context)
        MapView(context).apply {
            getMapAsync { mapboxMap ->
                setMapInstance(mapboxMap)
                mapboxMap.apply {
                    setStyle(MapStyleUrl.value) {
                        val locationComponentOptions =
                            LocationComponentOptions
                                .builder(context)
                                .pulseEnabled(true)
                                .build()
                        val locationComponentActivationOptions =
                            LocationComponentActivationOptions.builder(context, it)
                                .locationComponentOptions(locationComponentOptions)
                                .useDefaultLocationEngine(true)
                                .build()
                        this.locationComponent.apply {
                            activateLocationComponent(locationComponentActivationOptions)
                            isLocationComponentEnabled = true
                            cameraMode = CameraMode.TRACKING
                            forceLocationUpdate(lastKnownLocation)
                        }
                        centerOnUser()
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

object MapStyleUrl {
    const val value = "https://static.maptoolkit.net/rapidapi/styles/city.json?rapidapi-key=${BuildConfig.RAPID_API_KEY}"
}