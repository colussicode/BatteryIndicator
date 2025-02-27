package com.example.batteryindicator

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BatteryIndicator(
    batteryLevel: Int?,
    paddingValues: PaddingValues,
    @DrawableRes leadingIcon: Int,
    @DrawableRes trailingIcon: Int,
){
    val batteryColor = when (batteryLevel) {
        in 0..20 -> Color.Red
        in 21..50 -> Color.Yellow
        else -> Color.Green
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(48.dp)
                    .padding(end = 16.dp),
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Row(
                modifier = Modifier.height(60.dp)
                    .width(210.dp)
                    .offset(3.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                        .padding(3.dp)
                        .background(
                            color = batteryColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .weight(1f),
                ) {  }
            }
            Box(
                modifier = Modifier.height(25.dp)
                    .width(10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ){}

            Icon(
                modifier = Modifier.size(48.dp)
                    .padding(start = 16.dp),
                painter = painterResource(id = trailingIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}