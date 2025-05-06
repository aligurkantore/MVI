package com.example.mvi.common.network

import com.example.mvi.common.util.FailViewType
import java.io.IOException

class NetworkUnavailableException : IOException()

class PagingFail(override val message: String, val failViewType: FailViewType) : Exception(message)