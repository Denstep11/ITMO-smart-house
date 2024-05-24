package com.example.myhome.ui.alerts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
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
import com.example.myhome.model.Scenario
import com.example.myhome.model.ScenarioMode
import com.example.myhome.model.TemperatureSensor
import com.example.myhome.model.WashingMachine
import com.example.myhome.model.YandexStation
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.clock.ClockDialog
import java.time.LocalTime.of

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlertSetCondition(openDialog: MutableState<Boolean>, newScenario: MutableState<Scenario>, devices: SnapshotStateList<Device>) {
    val openTime = remember { mutableStateOf(false) }
    val openSensor = remember { mutableStateOf(false) }
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
        title = { Text(text = "Условие по:") },
        text = {
            Column {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            newScenario.value.mode = ScenarioMode.TIME
                            openTime.value = true
                        },
                    shape = RoundedCornerShape(15.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Время", fontSize = 20.sp, modifier = Modifier.padding(7.dp))
                        if (openTime.value) {
                            val selectedTime = remember { mutableStateOf(of(8, 20, 0)) }
                            ClockDialog(
                                state = rememberUseCaseState(
                                    visible = true,
                                    onCloseRequest = { openTime.value = false }),
                                selection = ClockSelection.HoursMinutes { hours, minutes ->
                                    selectedTime.value = of(hours, minutes, 0)
                                    newScenario.value.modeDescription.value = selectedTime.value.toString()
                                },
                                config = ClockConfig(
                                    boundary = of(0, 0, 0)..of(12, 59, 0),
                                    defaultTime = selectedTime.value,
                                    is24HourFormat = true
                                ),
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            newScenario.value.mode = ScenarioMode.SENSOR
                            openSensor.value = true
                        },
                    shape = RoundedCornerShape(15.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Датчик", fontSize = 20.sp, modifier = Modifier.padding(7.dp))
                        if(openSensor.value){
                            AlertSetSensor(openSensor, devices, newScenario)
                        }
                    }
                }
            }
        }
    )
}