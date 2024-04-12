package com.example.myhome.model

import com.example.myhome.interfaces.MachineMode
import com.example.myhome.R

class Dishwasher(id: Int, name: String, description: String) : Device(id, name, description),
    MachineMode {
    override var imgId = R.drawable.dishwasher
    override val modelDescription = "Режим: "
    override val modelList: List<String> = listOf("Экономный", "Ночной", "Быстрый", "Мощный")
    override var mode: String = modelList[0]
}