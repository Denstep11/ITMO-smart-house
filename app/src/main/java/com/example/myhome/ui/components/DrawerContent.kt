package com.example.myhome.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myhome.R
import com.example.myhome.ui.alerts.AlertAddHome
import com.example.myhome.model.Home
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    drawerState: DrawerState,
    scope: CoroutineScope,
    homes: MutableList<Home>,
    navController: NavController
) {
    val openNewHome = remember { mutableStateOf(false) }
    Column {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(13.dp, 20.dp, 10.dp, 10.dp)
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(
            text = "MyName",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(13.dp, 5.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .clickable {
                    navController.navigate("main")
                }) {
            Icon(Icons.Default.Home, contentDescription = "Главная")
            Text(text = "Главная", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .clickable {
                    openNewHome.value = true
                    scope.launch {
                        drawerState.close()
                    }
                }) {
            Icon(Icons.Default.Add, contentDescription = "Новый дом")
            Text(text = "Новый дом", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .clickable {
                    navController.navigate("scen")
                }) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Сценарии")
            Text(text = "Сценарии", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .clickable {
                    navController.navigate("auth")
                }) {
            Icon(Icons.Default.ExitToApp, contentDescription = "Выход")
            Text(text = "Выход", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
        if (openNewHome.value) {
            AlertAddHome(open = openNewHome, homes)
        }
    }
}