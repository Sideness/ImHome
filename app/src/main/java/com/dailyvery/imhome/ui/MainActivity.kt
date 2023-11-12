package com.dailyvery.imhome.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.dailyvery.imhome.core.navigation.NavHost
import com.dailyvery.imhome.ui.theme.ImHomeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ImHomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost()
                }
            }
        }

        askForLocationPermission()
    }

    private fun askForLocationPermission() {
        val granted = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(granted != PackageManager.PERMISSION_GRANTED) {
            val requestLocationPermissionLauncher =
                registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                    if(isGranted) {
                        viewModel.centerLocationOnUser()
                    } else {
                        //todo display explanation
                    }
            }
            requestLocationPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            viewModel.centerLocationOnUser()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImHomeTheme {

    }
}