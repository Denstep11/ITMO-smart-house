package com.example.myhome.ui.alerts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhome.model.Device

@Composable
fun SettingDevice(openSetting: MutableState<Boolean>, device: Device) {
    var newName = device.name
    var newDescription = device.description
    AlertDialog(
        onDismissRequest = { openSetting.value = false },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        openSetting.value = false
                        device.name = newName
                        device.description = newDescription
                    }
                ) {
                    Text("Сохранить", fontSize = 22.sp)
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
                    text = device.name,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
                Button(
                    onClick = {
                        openSetting.value = false
                    }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Выход",
                    )
                }
            }
        },
        text = {
            Column {
                val messageName = remember { mutableStateOf(device.name) }
                val messageDescription = remember { mutableStateOf(device.description) }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = device.imgId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                }
                Row {
                    TextField(
                        value = messageName.value,
                        onValueChange = { newText ->
                            messageName.value = newText
                            newName = newText
                        })
                }
                Row(
                    modifier = Modifier.padding(vertical = 15.dp)
                ) {
                    TextField(
                        value = messageDescription.value,
                        onValueChange = { newText ->
                            messageDescription.value = newText
                            newDescription = newText
                        })
                }
            }
        }
    )
}