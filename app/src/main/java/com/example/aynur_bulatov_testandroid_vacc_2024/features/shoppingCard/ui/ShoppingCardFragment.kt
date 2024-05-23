package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentShoppingCardBinding

class ShoppingCardFragment : Fragment() {

    private val viewModel: ShoppingCardViewModel by viewModels()
    private var _binding: FragmentShoppingCardBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_shopping_card, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}