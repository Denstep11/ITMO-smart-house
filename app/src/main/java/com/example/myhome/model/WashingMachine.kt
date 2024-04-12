package com.example.myhome.model

import com.example.myhome.interfaces.MachineMode
import com.example.myhome.R

class WashingMachine(id: Int, name: String, description: String) : Device(id, name, description),
    MachineMode {
    override var imgId = R.drawable.washing_machine
    override val modelDescription = "Режим: "
    override val modelList: List<String> = listOf("Экономный", "Холодный", "Горячий", "Хлопок")
    override var mode: String = modelList[0]
}