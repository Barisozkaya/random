package com.example.random.shared.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.random.shared.dialogs.LoadingDialog
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (this::binding.isInitialized) return binding.root
        binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setupListener()
    }

    protected open fun setupListener() {
    }

    protected open fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner) {
            loading(isLoading = it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            error(message = it)
        }
    }

    private fun error(message: String) {
        this.view?.let { view ->
            val snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snack.show()
        }
    }

    private fun loading(isLoading: Boolean) {
        when(isLoading) {
            true -> loadingDialog.show()
            false -> loadingDialog.dismiss()
        }
    }
}
