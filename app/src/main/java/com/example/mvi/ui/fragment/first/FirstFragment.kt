package com.example.mvi.ui.fragment.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mvi.common.base.BaseFragment
import com.example.mvi.common.extensions.collectIn
import com.example.mvi.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding, FirstEvent, FirstState, FirstEffect>() {

    override val viewModel: FirstViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstBinding {
        return FragmentFirstBinding.inflate(layoutInflater)
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
                is FirstEffect.ShowToast -> {}
            }
        }
    }
}