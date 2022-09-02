package com.example.random.scene.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.random.databinding.FragmentHomeBinding
import com.example.random.scene.details.models.DetailsModel
import com.example.random.shared.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
        observeViewModel()
    }

    private fun setupListener() {
        binding.catButton.setOnClickListener {
            viewModel.getCat()
        }

        binding.dogButton.setOnClickListener {
            viewModel.getCat()
        }
    }

    private fun observeViewModel() {
        viewModel.catLiveData.observe(viewLifecycleOwner) {
            val model = DetailsModel(url = it.first().url)
            navigateDetail(model = model)
        }
        viewModel.dogLiveData.observe(viewLifecycleOwner) {
            val model = DetailsModel(url = it.first().url)
            navigateDetail(model = model)
        }
    }

    private fun navigateDetail(model: DetailsModel) {
        val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(model)
        findNavController().navigate(direction)
    }
}
