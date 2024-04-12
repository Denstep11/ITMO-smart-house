package com.example.myhome.model

import com.example.myhome.R
import com.example.myhome.interfaces.Temperature

class Conditioner(id: Int, name: String, description: String) : Device(id, name, description),
    Temperature {
    override var imgId = R.drawable.conditioner
    override var temperature: Float = 25f
    override val tempMax: Float = 30f
    override val tempMin: Float = 16f
    override val tempDescription = "Температура воздуха:"
}