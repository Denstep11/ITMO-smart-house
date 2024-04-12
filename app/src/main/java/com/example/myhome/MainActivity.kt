package com.example.myhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhome.model.Buld
import com.example.myhome.model.Home
import com.example.myhome.model.MainPage
import com.example.myhome.model.Scenario
import com.example.myhome.ui.pages.Authorization
import com.example.myhome.ui.pages.Main
import com.example.myhome.ui.pages.Registration
import com.example.myhome.ui.pages.Scenarios
import com.example.myhome.ui.pages.SettingScenarios

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint(
        "MutableCollectionMutableState", "UnusedMaterial3ScaffoldPaddingParameter",
        "UnrememberedMutableState"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homes = remember {
                mutableStateListOf<Home>()
            }

            val scenarios = remember {
                mutableStateListOf<Scenario>(
                    Scenario(1, "Сценарий", "Начи ничего не делает"),
                    Scenario(2, "Сценарий", "Начи ничего не делает")
                )
            }

            val mainHome = remember {
                mutableStateOf(
                    Home(
                        "Квартира", mutableStateListOf(
                            Buld(1, "Лампочка 1", "Включает свет"),
                            Buld(2, "Лампочка 2", "Включает свет"),
                            Buld(3, "Лампочка 3", "Включает свет")
                        ),
                        scenarios
                    )
                )
            }

            val mainPage by remember { mutableStateOf(MainPage(mainHome, homes)) }
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            if (mainPage.homes.size == 0) {
                mainPage.homes.add(mainPage.mainHome.value)
            }
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    Main(navController, mainPage)
                }
                composable("reg") {
                    Registration(navController, mainPage)
                }
                composable("auth") {
                    Authorization(navController, mainPage)
                }
                composable("scen") {
                    Scenarios(navController, mainPage)
                }
                composable("addScen") {
                    SettingScenarios(navController, mainPage)
                }
            }
        }
    }
}


