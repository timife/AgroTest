package com.timife.agromall.response

data class Data(
    val farmers: List<Farmer>,
    val imgBaseUrl: String,
    val pagination: Pagination
)