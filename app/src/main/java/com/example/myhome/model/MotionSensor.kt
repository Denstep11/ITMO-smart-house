package com.example.myhome.model

import com.example.myhome.R
import com.example.myhome.interfaces.Sensor

class MotionSensor(id: Int, name: String, description: String) : Device(id, name, description), Sensor {
    override var imgId = R.drawable.motion_sensor;
}