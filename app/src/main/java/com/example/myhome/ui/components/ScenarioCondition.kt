package com.example.myhome.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myhome.R
import com.example.myhome.model.Device
import com.example.myhome.model.Scenario
import com.example.myhome.model.ScenarioMode
import com.example.myhome.ui.alerts.AlertSetCondition
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalTime.of

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScenarioCondition(newScenario: MutableState<Scenario>, devices: SnapshotStateList<Device>) {
    val openDialog = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    openDialog.value = true;
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (openDialog.value) {
                    AlertSetCondition(openDialog, newScenario, devices)
                }
                Image(
                    painter = painterResource(id = R.drawable.scen),
                    contentDescription = "картинка",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    if (newScenario.value.mode == ScenarioMode.SENSOR){
                        Text(fontWeight = FontWeight.Bold, text = "Датчик")
                        Text(text = newScenario.value.modeDescription.value)
                    }
                    else{
                        Text(fontWeight = FontWeight.Bold, text = "Время")
                        Text(text = newScenario.value.modeDescription.value)
                    }
                }
            }
        }
    }
}