package com.example.myhome.ui.alerts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhome.model.Buld
import com.example.myhome.model.Button
import com.example.myhome.model.CoffeeMachine
import com.example.myhome.model.Conditioner
import com.example.myhome.model.Device
import com.example.myhome.model.Dishwasher
import com.example.myhome.model.Kettle
import com.example.myhome.model.LeakSensor
import com.example.myhome.model.MotionSensor
import com.example.myhome.model.OpeningSensor
import com.example.myhome.model.TemperatureSensor
import com.example.myhome.model.WashingMachine
import com.example.myhome.model.YandexStation

@Composable
fun AlertAddDevices(openDialog: MutableState<Boolean>, devices: SnapshotStateList<Device>) {
    AlertDialog(
        onDismissRequest = { openDialog.value = false },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { openDialog.value = false }
                ) {
                    Text("Назад", fontSize = 22.sp)
                }
            }
        },
        title = { Text(text = "Выберите устройство") },
        text = {
            val newId = if (devices.isEmpty()) {
                0
            } else {
                devices.last().id + 1
            }
            Column {
                Row {
                    DrawDeviceInAlert(devices, Buld(newId, "Лампочка", "Cвет в комнате"))
                    DrawDeviceInAlert(devices, Button(newId, "Конопка", "Включает свет"))
                    DrawDeviceInAlert(
                        devices,
                        Conditioner(newId, "Кондиционер", "Кондиционер в спальне")
                    )
                }
                Row {
                    DrawDeviceInAlert(devices, LeakSensor(newId, "Датчик утечки воды", "В ванной"))
                    DrawDeviceInAlert(
                        devices,
                        MotionSensor(newId, "Датчик движения", "У входной двери")
                    )
                    DrawDeviceInAlert(
                        devices,
                        OpeningSensor(newId, "Датчик открытия двери", "Балконная дверь")
                    )
                }
                Row {
                    DrawDeviceInAlert(
                        devices,
                        TemperatureSensor(newId, "Датчик температуры", "На кухне")
                    )
                    DrawDeviceInAlert(devices, YandexStation(newId, "Алиса", "В комнате"))
                    DrawDeviceInAlert(devices, Kettle(newId, "Чайник", "На кухне"))
                }
                Row {
                    DrawDeviceInAlert(devices, CoffeeMachine(newId, "Кофе машина", "На кухне"))
                    DrawDeviceInAlert(devices, Dishwasher(newId, "Посудомойка", "На кухне"))
                    DrawDeviceInAlert(devices, WashingMachine(newId, "Стиралка", "Ванна комната"))
                }
            }
        }
    )
}

@Composable
fun DrawDeviceInAlert(devices: SnapshotStateList<Device>, dv: Any) {
    val device = dv as Device;
    Image(
        painter = painterResource(id = device.imgId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(64.dp)
            .clip(CircleShape)
            .clickable {
                devices.add(device)
            }
    )
}