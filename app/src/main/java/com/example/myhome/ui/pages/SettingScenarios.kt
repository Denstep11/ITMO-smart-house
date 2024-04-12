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
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myhome.model.MainPage
import com.example.myhome.ui.components.DrawerContent
import com.example.myhome.ui.components.ItemAddScenarioButton
import com.example.myhome.ui.components.ItemScenario
import com.example.myhome.ui.components.ItemTopBar

@Composable
fun SettingScenarios(navController: NavController, mainPage: MainPage) {
    Scaffold(
        topBar = { Text(text = "Бар")},
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