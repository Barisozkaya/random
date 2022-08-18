package com.example.random.scene.home

import androidx.fragment.app.viewModels
import com.example.random.databinding.FragmentHomeBinding
import com.example.random.shared.base.BaseFragment

// TODO: Hilt implementation for ViewModel
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()
}