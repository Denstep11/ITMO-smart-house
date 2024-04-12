package com.example.myhome.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhome.interfaces.MachineMode

@Composable
fun SetMode(machineMode: MachineMode) {
    var mode by remember { mutableStateOf(machineMode.mode) }
    var expanded by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(fontWeight = FontWeight.Bold, text = machineMode.modelDescription + " ")
        Text(text = mode, fontSize = 15.sp)
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Показать меню")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (thisMode in machineMode.modelList) {
                Text(
                    text = thisMode,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            mode = thisMode
                        })
            }
        }
    }
    machineMode.mode = mode
    //Log.d("Temp:", temperature.temperature.toString())
}