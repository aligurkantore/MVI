package com.example.mvi.ui.fragment.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mvi.common.base.BaseFragment
import com.example.mvi.common.extensions.collectIn
import com.example.mvi.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondEvent, SecondState, SecondEffect>() {

    override val viewModel: SecondViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun bindScreen() {
        collectState()
        collectEffect()
    }

    private fun collectState() = with(binding) {
        viewModel.state.collectIn(viewLifecycleOwner) { state->
            //   state.
        }
    }

    private fun collectEffect() {
        viewModel.effect.collectIn(viewLifecycleOwner) { effect ->
            when(effect) {
                is SecondEffect.ShowToast -> {}
            }
        }
    }
}