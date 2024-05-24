package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentShoppingCartBinding

class ShoppingCartFragment : Fragment() {

    private val viewModel: ShoppingCartViewModel by viewModels()
    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}