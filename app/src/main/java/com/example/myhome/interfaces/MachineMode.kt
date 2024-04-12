package com.example.myhome.interfaces

interface MachineMode {
    val modelDescription: String
    val modelList: List<String>
    var mode: String
}