package com.example.mvi.ui.fragment.first

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mvi.common.base.BaseFragment
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

    override fun setupListeners() {
        //todo
    }

    override fun renderState(state: FirstState) {
        viewModel.setEvent(FirstEvent.FetchData(""))
    }

    override fun handleEffect(effect: FirstEffect) {
        when (effect) {
            is FirstEffect.ShowToast -> {
                Toast.makeText(requireContext(), effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}