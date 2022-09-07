package com.example.random.scene.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.random.R
import com.example.random.databinding.FragmentDetailsBinding
import com.example.random.shared.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>(
    FragmentDetailsBinding::inflate
) {
    override val viewModel by viewModels<DetailsViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_homeFragment)
        }
    }
}
