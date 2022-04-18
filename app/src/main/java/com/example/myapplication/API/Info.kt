package com.example.myapplication.API

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: Any? = null
)