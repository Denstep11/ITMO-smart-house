package com.example.myhome.model

import com.example.myhome.R

class MotionSensor(id: Int, name: String, description: String) : Device(id, name, description) {
    override var imgId = R.drawable.motion_sensor;
}