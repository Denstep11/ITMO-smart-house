package com.example.myhome.ui.alerts

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.myhome.ui.components.ItemAddDeviceButton
import com.example.myhome.ui.components.ItemDevice
import com.example.myhome.ui.components.ItemDeviceInScenarioAlert

@Composable
fun AlertAddDeviceInScenario(
    openDialog: MutableState<Boolean>,
    devices: SnapshotStateList<Device>,
    scenarioDevices: SnapshotStateList<Device>
) {
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
            LazyColumn(
            ) {
                items(devices) { device ->
                    Row(modifier = Modifier.clickable {
                        scenarioDevices.add(device)
                        Log.d("Temp:", device.name)
                    }) {
                        ItemDeviceInScenarioAlert(device)
                    }
                }
            }
        }
    )
}