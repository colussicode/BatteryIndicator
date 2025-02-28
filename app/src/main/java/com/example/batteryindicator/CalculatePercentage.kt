package com.example.batteryindicator

fun calculateBatteryColorSize(
    percentage: Int,
    maxWidth: Int = 210
) = (percentage / 100f) * maxWidth
