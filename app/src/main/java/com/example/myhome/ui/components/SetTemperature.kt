package com.example.myhome.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myhome.interfaces.Temperature

@Composable
fun SetTemperature(temperature: Temperature) {
    var sliderPosition by remember { mutableStateOf(temperature.temperature) }
    Row {
        Text(fontWeight = FontWeight.Bold, text = temperature.tempDescription + " ")
        Text(text = sliderPosition.toString(), fontSize = 15.sp)
    }
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = temperature.tempMin..temperature.tempMax,
        steps = (temperature.tempMax - temperature.tempMin - 1).toInt(),
    )
    temperature.temperature = sliderPosition
    Log.d("Temp:", temperature.temperature.toString())
}
