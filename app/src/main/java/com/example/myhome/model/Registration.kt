package com.example.myhome.model

class Registration {
    fun check(login: String, password: String): Boolean {
        if(login == "admin" && password == "123"){
            return false
        }
        return !(login.length<3 || password.length <3)
    }
}