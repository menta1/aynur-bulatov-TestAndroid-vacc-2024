package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentMainScreenBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels()
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProdAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initData()

        adapter = ProdAdapter { clickProd(product = it) }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is MainState.Content -> {
                            adapter.setData(it.products)
                            binding.progressBar.visibility = View.GONE
                            binding.recycler.visibility = View.VISIBLE
                        }

                        MainState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.recycler.visibility = View.GONE
                        }
                    }
                }
            }
        }

    }

    private fun clickProd(product: ProductModel) {
        viewModel.save(product)
        findNavController().navigate(
            MainScreenFragmentDirections.actionMainScreenFragmentToDetailsScreenFragment(
                product.id.toString()
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}