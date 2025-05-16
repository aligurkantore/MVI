package com.example.mvi.ui.fragment.first

import com.example.mvi.common.base.BaseViewModel
import com.example.mvi.common.base.Effect
import com.example.mvi.common.base.Event
import com.example.mvi.common.base.State
import com.example.mvi.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val useCase: UseCase
) : BaseViewModel<FirstEvent, FirstState, FirstEffect>() {

    override fun setInitialState() = FirstState(false)

    override fun handleEvents(event: FirstEvent) {
        when (event) {
            is FirstEvent.FetchData -> {
                setEffect { FirstEffect.ShowToast("") }
            }
        }
    }


}

sealed class FirstEvent : Event {
    class FetchData(val token: String) : FirstEvent()
}

data class FirstState(
    val isLoading: Boolean = false,
) : State

sealed class FirstEffect : Effect {
    data class ShowToast(val message: String) : FirstEffect()
}