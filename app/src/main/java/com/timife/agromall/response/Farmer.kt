package com.timife.agromall.response

data class Farmer(
    val farmer_id: String,
    val full_name: String,
    val lga: String,
    val mobile_no: String,
    val passport_photo: String,
    val state: String
)