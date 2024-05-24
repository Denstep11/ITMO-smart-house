package com.example.myhome.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.myhome.R

class Scenario(var id: Int, var name: String, var description: String, var devices: SnapshotStateList<Device>) {
    var mode: ScenarioMode = ScenarioMode.SENSOR
    var modeDescription: MutableState<String> = mutableStateOf("Не задано")
    var switch: MutableState<Boolean> = mutableStateOf(false)
    var imgId = R.drawable.scen
}