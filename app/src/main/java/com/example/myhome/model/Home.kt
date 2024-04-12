package com.example.myhome.model

import androidx.compose.runtime.snapshots.SnapshotStateList

class Home(var name: String, var devices: SnapshotStateList<Device>, var scenarios: SnapshotStateList<Scenario>) {
}