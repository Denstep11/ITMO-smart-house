package com.example.myhome.ui.components

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
import com.example.myhome.R
import com.example.myhome.model.Device
import com.example.myhome.ui.alerts.AlertSetCondition

@Composable
fun ItemDeviceInScenarioAlert(device: Device) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = device.imgId),
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
                    Text(fontWeight = FontWeight.Bold, text = device.name)
                    Text(text = device.description)
                }
            }
        }
    }
}