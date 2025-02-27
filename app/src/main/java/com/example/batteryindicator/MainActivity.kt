package com.example.batteryindicator

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.batteryindicator.ui.theme.BatteryIndicatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var batteryLevel: Int?
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
                baseContext.registerReceiver(null, ifilter)
            }

            batteryLevel = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
            println("$batteryLevel TICO TICO NO FUBA")

            BatteryIndicatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BatteryIndicator(
                        batteryLevel,
                        innerPadding,
                        R.drawable.ic_heart,
                        R.drawable.ic_clover
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BatteryIndicatorTheme {
    }
}