package com.example.mvi.data.repository

import android.content.Context
import com.example.mvi.common.base.BaseRepository
import com.example.mvi.data.source.remote.Service
import com.example.mvi.domain.repository.Repository

class RepositoryImpl(
    private val context: Context,
    private val service: Service
) : BaseRepository(), Repository {}