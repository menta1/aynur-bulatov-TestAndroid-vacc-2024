package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentShoppingCartBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShoppingCartFragment : Fragment() {

    private val viewModel: ShoppingCartViewModel by viewModels()
    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ShopAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingCartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAll()
        adapter = ShopAdapter { clickProd(it) }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.list.collect { state ->
                    when (state) {
                        is ShopState.Content -> {
                            adapter.setData(state.result)
                            binding.button2.visibility = View.VISIBLE
                            binding.listEmpty.visibility = View.GONE
                        }

                        ShopState.Default -> {}

                        is ShopState.Empty -> {
                            adapter.setData(state.result)
                            binding.button2.visibility = View.GONE
                            binding.listEmpty.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }

        binding.button2.setOnClickListener {
            viewModel.buySelectedItems()
            Toast.makeText(requireContext(), "Поздравляем с покупкой", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clickProd(result: Pair<Boolean, ProductModel>) {
        viewModel.selectedItems(result)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}