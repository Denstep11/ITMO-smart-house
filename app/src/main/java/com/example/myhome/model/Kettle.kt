package com.example.myhome.model

import com.example.myhome.R
import com.example.myhome.interfaces.Temperature

class Kettle(id: Int, name: String, description: String) : Device(id, name, description),
    Temperature {
    override var imgId = R.drawable.kettle
    override var temperature: Float = 50f
    override val tempMax: Float = 100f;
    override val tempMin: Float = 40f;
    override val tempDescription = "Температура воды:"
}