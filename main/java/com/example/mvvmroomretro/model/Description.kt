package com.example.mvvmroomretro.model

data class Description(
    val statusCode: Int,
    val message: String,
    val data: List<Datum>
)
