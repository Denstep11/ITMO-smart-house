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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myhome.model.MainPage
import com.example.myhome.ui.components.DrawerContent
import com.example.myhome.ui.components.ItemAddDeviceButton
import com.example.myhome.ui.components.ItemAddScenarioButton
import com.example.myhome.ui.components.ItemDevice
import com.example.myhome.ui.components.ItemScenario
import com.example.myhome.ui.components.ItemTopBar

@Composable
fun Scenarios(navController: NavController, mainPage: MainPage){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                        items(mainPage.mainHome.value.scenarios) { scenario ->
                            ItemScenario(scenario, mainPage.mainHome.value.scenarios)
                        }
                        item {
                            Spacer(modifier = Modifier.height(60.dp))
                        }
                    }

                }
                    ItemAddScenarioButton(mainPage.mainHome.value.scenarios, navController)
            }
        }
    }
}
