package com.example.myhome.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myhome.model.Buld
import com.example.myhome.ui.components.DrawerContent
import com.example.myhome.ui.components.ItemAddDeviceButton
import com.example.myhome.ui.components.ItemDevice
import com.example.myhome.ui.components.ItemTopBar
import com.example.myhome.model.Device
import com.example.myhome.model.Home
import com.example.myhome.model.MainPage

@Composable
fun Main(navController: NavController, mainPage: MainPage ) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    if (mainPage.homes.size == 0) {
        mainPage.homes.add(mainPage.mainHome.value)
    }

    ModalNavigationDrawer(
        scrimColor = Color.White,
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(drawerState, scope, mainPage.homes, navController)
        },
    ) {
        Scaffold(
            topBar = { ItemTopBar(drawerState, scope, mainPage) },
        ) { innerPadding ->
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    LazyColumn(
                        modifier = Modifier.weight(5f)
                    ) {
                        items(mainPage.mainHome.value.devices) { device ->
                            ItemDevice(item = device, mainPage.mainHome.value.devices)
                        }
                        item {
                            Spacer(modifier = Modifier.height(60.dp))
                        }
                    }

                }
                ItemAddDeviceButton(mainPage.mainHome.value.devices)
            }
        }
    }
}