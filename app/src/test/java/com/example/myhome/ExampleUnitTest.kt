package com.example.myhome

import com.example.myhome.model.Authorization
import com.example.myhome.model.Registration
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var authorization: Authorization
    private lateinit var registration: Registration

    @Before
    fun init(){
        authorization = Authorization()
        registration = Registration()
    }


    @Test
    fun authTrue() {
        assertEquals(authorization.check("admin", "123"), true)
    }

    @Test
    fun authFalse() {
        assertEquals(authorization.check("admin", "1234"), false)
    }

    @Test
    fun regHaveUser() {
        assertEquals(registration.check("admin", "123"), false)
    }
    @Test
    fun regShortLoginLength() {
        assertEquals(registration.check("gg", "1234"), false)
    }
    @Test
    fun regShortPasswordLength() {
        assertEquals(registration.check("bts", "14"), false)
    }
    @Test
    fun regTrue() {
        assertEquals(registration.check("btsfan", "qwert"), true)
    }
}