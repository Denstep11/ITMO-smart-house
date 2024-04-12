package com.example.myhome.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.myhome.R

open class Device(var id: Int, var name: String, open var description: String)  {
    var switch: MutableState<Boolean> = mutableStateOf(false)
    open var imgId = R.drawable.lamp
}