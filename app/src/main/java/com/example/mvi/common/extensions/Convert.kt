package com.example.mvi.common.extensions

fun Double?.orZero() = this ?: 0.0

fun Int?.orZero() = this ?: 0

fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true

fun IntArray?.orEmpty() = this ?: emptyArray<Int>().toIntArray()