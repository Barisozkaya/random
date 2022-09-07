package com.example.random.scene.home

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

    override fun setupListener() {
        super.setupListener()

        binding.catButton.setOnClickListener {
            viewModel.getCat()
        }

        binding.dogButton.setOnClickListener {
            viewModel.getDog()
        }
    }

    override fun observeViewModel() {
        super.observeViewModel()

        viewModel.cat.observe(viewLifecycleOwner) {
            val model = DetailsModel(url = it.first().url)
            navigateDetail(model = model)
        }
        viewModel.dog.observe(viewLifecycleOwner) {
            val model = DetailsModel(url = it.first().url)
            navigateDetail(model = model)
        }
    }

    private fun navigateDetail(model: DetailsModel) {
        val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(model)
        findNavController().navigate(direction)
    }
}
