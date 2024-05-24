package com.example.myhome.model

class Authorization {
    fun check(login: String, password: String): Boolean {
        return login == "admin" && password == "123"
    }
}