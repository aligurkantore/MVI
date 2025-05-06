package com.example.mvi.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mvi.common.extensions.collectIn

abstract class BaseFragment<Binding : ViewBinding, Event, State, Effect> : Fragment() {

    private var _binding: Binding? = null
    protected val binding get() = _binding!!

    protected abstract val viewModel: BaseViewModel<Event, State, Effect>
    protected abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = createBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
        observeEffect()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeState() {
        viewModel.state.collectIn(viewLifecycleOwner) {
            renderState(it)
        }
    }


    private fun observeEffect() {
        viewModel.effect.collectIn(viewLifecycleOwner) {
            handleEffect(it)
        }
    }

    abstract fun setupListeners()
    abstract fun renderState(state: State)
    abstract fun handleEffect(effect: Effect)
}