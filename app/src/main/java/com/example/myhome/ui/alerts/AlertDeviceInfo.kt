package com.example.myhome.ui.alerts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhome.interfaces.MachineMode
import com.example.myhome.ui.components.SetMode
import com.example.myhome.ui.components.SetTemperature
import com.example.myhome.interfaces.Temperature
import com.example.myhome.model.Device

@Composable
fun AlertRenameDevice(openDialog: MutableState<Boolean>, device: Device, devices: SnapshotStateList<Device>) {
    //val device = dv as Device
    val openSetting = remember { mutableStateOf(false) }
    AlertDialog(
        onDismissRequest = { openDialog.value = false },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    onClick = {
                        openDialog.value = false
                        devices.remove(device)
                    }
                ) {
                    Text("Удалить", fontSize = 22.sp)
                }
                Button(
                    onClick = { openDialog.value = false }
                ) {
                    Text("OK", fontSize = 22.sp)
                }
            }
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(190.dp),
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    text = device.name,
                    textAlign = TextAlign.Center,
                )
                Button(
                    onClick = {
                        openSetting.value = true;
                    }) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Настройка устройсва",
                    )
                }
            }
        },
        text = {
            if (openSetting.value) {
                SettingDevice(openSetting = openSetting, device = device)
            }
            Column {
                val messageName = remember { mutableStateOf(device.name) }
                val messageDescription = remember { mutableStateOf(device.description) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = device.imgId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                }
                Row {
                    Text(fontWeight = FontWeight.Bold, text = "Название: ")
                    Text(text = device.name)
                }
                Row(
                    modifier = Modifier.padding(vertical = 15.dp)
                ) {
                    Text(fontWeight = FontWeight.Bold, text = "Описание: ")
                    Text(text = device.description)
                }
                when (device) {
                    is Temperature -> {
                        SetTemperature(device as Temperature)
                        Log.d("Temp 2:", device.temperature.toString())
                    }
                    is MachineMode -> {
                        SetMode(device as MachineMode)
                    }
                }
            }
        }
    )
}