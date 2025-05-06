package com.example.mvi.domain.usecase

import com.example.mvi.domain.repository.Repository
import javax.inject.Inject

class UseCase @Inject constructor(private var repository: Repository)