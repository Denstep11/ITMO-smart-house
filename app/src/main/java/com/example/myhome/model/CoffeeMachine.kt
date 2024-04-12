package com.example.myhome.model

import com.example.myhome.interfaces.MachineMode
import com.example.myhome.R

class CoffeeMachine(id: Int, name: String, description: String) : Device(id, name, description),
    MachineMode {
    override var imgId = R.drawable.coffe_machine
    override val modelDescription = "Напиток: "
    override val modelList: List<String> = listOf("Эспрессо", "Американо", "Капучино", "Латте")
    override var mode: String = modelList[0]
}
