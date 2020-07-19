package com.readyfo.yaclone.core.common

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.readyfo.yaclone.R
import com.readyfo.yaclone.core.events.EventObserver

abstract class BaseFragment : Fragment() {

    abstract fun getViewModel(): BaseViewModel

    open fun onHandleError(e: Exception) {
        Toast.makeText(
            requireContext(),
            getString(R.string.errorPattern, e.message ?: e.javaClass.simpleName),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeError(getViewModel())
    }

    private fun observeError(viewModel: BaseViewModel) {
        viewModel.error.observe(viewLifecycleOwner, EventObserver { e ->
            onHandleError(e)
        })
    }
}