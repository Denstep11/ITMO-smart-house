package com.example.myhome.ui.alerts.scenario

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.myhome.interfaces.Sensor
import com.example.myhome.model.Device
import com.example.myhome.model.Scenario
import com.example.myhome.model.ScenarioMode
import com.example.myhome.ui.components.scenario.ItemDeviceInScenarioAlert

@Composable
fun AlertSetSensor(
    openDialog: MutableState<Boolean>,
    devices: SnapshotStateList<Device>,
    newScenario: MutableState<Scenario>
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
        title = { Text(text = "Выберите датчик") },
        text = {
            LazyColumn(
            ) {
                items(devices) { device ->
                    if (device is Sensor) {
                        Row(modifier = Modifier.clickable {
                            newScenario.value.modeDescription.value = device.name
                            newScenario.value.mode = ScenarioMode.SENSOR
                            openDialog.value = false
                        }) {
                            ItemDeviceInScenarioAlert(device)
                        }
                    }
                }
            }
        }
    )
}