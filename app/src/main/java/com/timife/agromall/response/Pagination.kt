package com.timife.agromall.response

data class Pagination(
    val currentPage: Int,
    val next: Int,
    val perPage: Int,
    val previous: Any,
    val total: Int,
    val totalPages: Int
)