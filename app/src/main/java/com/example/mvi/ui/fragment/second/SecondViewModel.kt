package com.example.mvi.ui.fragment.second

import com.example.mvi.common.base.BaseViewModel
import com.example.mvi.common.base.Effect
import com.example.mvi.common.base.Event
import com.example.mvi.common.base.State
import com.example.mvi.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(private val useCase: UseCase) :
    BaseViewModel<SecondEvent, SecondState, SecondEffect>() {
    override fun setInitialState() = SecondState(false)

    override fun handleEvents(event: SecondEvent) {
        when (event) {
            is SecondEvent.FetchData -> {
                setEffect { SecondEffect.ShowToast("") }
            }
        }
    }
}

sealed class SecondEvent : Event {
    class FetchData(val token: String) : SecondEvent()
}

data class SecondState(
    val isLoading: Boolean = false,
) : State

sealed class SecondEffect : Effect {
    data class ShowToast(val message: String) : SecondEffect()
}