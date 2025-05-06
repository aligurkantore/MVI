package com.example.mvi.ui.fragment.second

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mvi.common.base.BaseFragment
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

    override fun setupListeners() {
        //todo
    }

    override fun renderState(state: SecondState) {
        viewModel.setEvent(SecondEvent.FetchData(""))
    }

    override fun handleEffect(effect: SecondEffect) {
        when (effect) {
            is SecondEffect.ShowToast -> {
                Toast.makeText(requireContext(), effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}