package com.example.random.scene.details

import androidx.fragment.app.viewModels
import com.example.random.databinding.FragmentDetailsBinding
import com.example.random.shared.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>(
    FragmentDetailsBinding::inflate
) {
    override val viewModel by viewModels<DetailsViewModel>()
}
