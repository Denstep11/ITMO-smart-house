package com.example.myhome.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.myhome.R

class Scenario(var id: Int, var name: String, var description: String) {
    var switch: MutableState<Boolean> = mutableStateOf(false)
    var imgId = R.drawable.scen
}