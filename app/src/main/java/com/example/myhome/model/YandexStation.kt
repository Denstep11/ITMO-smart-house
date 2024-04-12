package com.example.myhome.model

import com.example.myhome.R

class YandexStation(id: Int, name: String, description: String) : Device(id, name, description) {
    override var imgId = R.drawable.yandex_station;
    var volume = 10
}