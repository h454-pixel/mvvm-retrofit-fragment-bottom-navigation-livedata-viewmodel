package com.example.mvvmroomretro.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Datum(
 val empId: String,
 val name: String,
 val technology: String,
 val address: String,
 val mobile_no: String,
 val lat: String,
 val lng: String,
 val image: String,
)