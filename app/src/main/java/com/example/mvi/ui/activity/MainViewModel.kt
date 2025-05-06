package com.example.mvi.ui.activity

import com.example.mvi.common.base.BaseViewModel
import com.example.mvi.common.base.Effect
import com.example.mvi.common.base.Event
import com.example.mvi.common.base.State

class MainViewModel : BaseViewModel<MainEvent, MainState, MainEffect>() {

    override fun setInitialState() = MainState()

    override fun handleEvents(event: MainEvent) {
        //Event işleme mantığı
    }
}

sealed interface MainEvent : Event

data class MainState(
    val isLoading: Boolean = false
): State

sealed interface MainEffect : Effect