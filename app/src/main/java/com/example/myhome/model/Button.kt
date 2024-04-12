package com.example.myhome.model

import com.example.myhome.R

class Button(id: Int, name: String, description: String) : Device(id, name, description) {
    override var imgId = R.drawable.button
}