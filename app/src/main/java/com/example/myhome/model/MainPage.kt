package com.example.myhome.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController

class MainPage(var mainHome: MutableState<Home>, var homes: SnapshotStateList<Home>) {
}